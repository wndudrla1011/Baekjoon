package graph.p2468;

import java.io.IOException;
import java.util.*;

public class Main {

    static boolean[][] visited; //방문 체크
    static int[][] A;
    static int N; //정사각형 길이
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int[] area; //각 비의 양에 따른 안전 영역 개수
    static int count; //수행 되는 BFS 횟수 == 안전 영역 개수

    public static void main(String[] args) throws IOException {
        N = readInt();
        A = new int[N][N];

        int max = Integer.MIN_VALUE; //최대 높이
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                A[i][j] = readInt();
                if (max < A[i][j])
                    max = A[i][j];
            }
        }

        area = new int[max];

        //각 높이마다 BFS -> 호출 횟수 == 안전 영역 개수
        for (int r = 0; r < max; r++) { //현재 비의 양
            count = 0;
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && A[i][j] > r) {
                        count++;
                        BFS(r, i, j);
                    }
                }
            }
            area[r] = count;
        }

        int ans = 0;
        for (int i = 0; i < max; i++) {
            if (ans < area[i])
                ans = area[i];
        }

        System.out.println(ans);
    }

    static void BFS(int r, int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        visited[i][j] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int y = now[0];
            int x = now[1];
            for (int t = 0; t < 4; t++) {
                int ny = y + dy[t];
                int nx = x + dx[t];
                if (ny >= 0 && ny < N && nx >= 0 && nx < N) {
                    if (!visited[ny][nx] && A[ny][nx] > r) {
                        visited[ny][nx] = true;
                        q.offer(new int[]{ny, nx});
                    }
                }
            }
        }
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c  = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
