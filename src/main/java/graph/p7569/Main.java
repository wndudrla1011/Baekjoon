package graph.p7569;

import java.io.*;
import java.util.*;

public class Main {

    static int X, Y, Z;
    static int[][][] A;
    static Queue<int[]> q = new LinkedList<>();
    //앞뒤상하좌우 탐색
    static int[] dz = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dx = {0, 0, 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        X = readInt(); //열 개수
        Y = readInt(); //행 개수
        Z = readInt(); //면 개수
        A = new int[Z][Y][X];

        for (int i = 0; i < Z; i++) {
            for (int j = 0; j < Y; j++) {
                for (int k = 0; k < X; k++) {
                    A[i][j][k] = readInt();
                    if (A[i][j][k] == 1)
                        q.offer(new int[]{i, j, k});
                }
            }
        }

        System.out.println(BFS());
    }

    static int BFS() {
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int z = now[0];
            int y = now[1];
            int x = now[2];
            for (int i = 0; i < 6; i++) {
                int nz = z + dz[i];
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (nz >= 0 && nz < Z && ny >= 0 && ny < Y && nx >= 0 && nx < X) {
                    if (A[nz][ny][nx] == 0) {
                        A[nz][ny][nx] = A[z][y][x] + 1; //다음 위치로 갈 때마다 일수 누적
                        q.offer(new int[]{nz, ny, nx});
                    }
                }
            }
        }

        int max = Integer.MIN_VALUE; //첫 도착(최소 일수) 중 가장 늦게 도착한 장소
        if (checkZero()) { //익지 않은 토마토가 남은 경우
            return -1;
        } else {
            for (int i = 0; i < Z; i++) {
                for (int j = 0; j < Y; j++) {
                    for (int k = 0; k < X; k++) {
                        if (max < A[i][j][k])
                            max = A[i][j][k];
                    }
                }
            }
        }

        return max - 1; //1부터 시작했으므로 1빼야 함
    }

    static boolean checkZero() {
        for (int i = 0; i < Z; i++) {
            for (int j = 0; j < Y; j++) {
                for (int k = 0; k < X; k++) {
                    if (A[i][j][k] == 0) return true;
                }
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
