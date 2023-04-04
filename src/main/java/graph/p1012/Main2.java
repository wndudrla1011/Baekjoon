package graph.p1012;

import java.io.IOException;

public class Main2 {

    static boolean[][] visited;
    static int[][] A;
    static int M, N;
    static int cnt;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int T = readInt();
        while (T-- > 0) {
            cnt = 0;
            M = readInt(); //행 개수
            N = readInt(); //열 개수
            visited = new boolean[M][N];
            A = new int[M][N];
            int K = readInt(); //배추 개수

            while (K-- > 0) {
                int i = readInt();
                int j = readInt();
                A[i][j] = 1;
            }

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && A[i][j] == 1) {
                        DFS(i, j);
                        cnt++;
                    }
                }
            }

            sb.append(cnt).append('\n');
        }

        System.out.println(sb);
    }

    static void DFS(int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                if (!visited[nx][ny] && A[nx][ny] == 1) {
                    DFS(nx, ny);
                }
            }
        }
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
