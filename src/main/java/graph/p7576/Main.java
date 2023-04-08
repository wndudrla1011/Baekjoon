package graph.p7576;

import java.io.*;
import java.util.*;

public class Main {

    static int[][] A;
    static Queue<int[]> q = new LinkedList<>();
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int M, N;

    public static void main(String[] args) throws IOException {
        M = readInt();
        N = readInt();
        A = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                A[i][j] = readInt();
                if (A[i][j] == 1)
                    q.offer(new int[]{i, j});
            }
        }

        System.out.println(BFS());
    }

    static int BFS() {
        while (!q.isEmpty()) {
            int[] tomato = q.poll();
            int y = tomato[0];
            int x = tomato[1];
            for (int t = 0; t < 4; t++) {
                int ny = y + dy[t];
                int nx = x + dx[t];
                if (ny >= 0 && ny < N && nx >= 0 && nx < M) {
                    if (A[ny][nx] == 0) {
                        A[ny][nx] = A[y][x] + 1; //다음 뎁스로 갈 때마다 누적
                        q.offer(new int[]{ny, nx});
                    }
                }
            }
        }

        int max = Integer.MIN_VALUE;
        if (checkZero()) { //0이 남음 == 익지 않은 토마토가 남음
            return -1;
        } else {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (max < A[i][j])
                        max = A[i][j];
                }
            }
        }

        return max - 1; //총 뎁스 - 1 == 최소 일수
    }

    static boolean checkZero() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (A[i][j] == 0)
                    return true;
            }
        }
        return false;
    }

    static int readInt() throws IOException {
        int n = 0;
        boolean isNegative = false;
        while (true) {
            int input = System.in.read();
            if (input <= 32) {
                return isNegative ? n * -1 : n;
            } else if (input == '-')
                isNegative = true;
            else
                n = (n << 3) + (n << 1) + (input & 15);
        }
    }

}
