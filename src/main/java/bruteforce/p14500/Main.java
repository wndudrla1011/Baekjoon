package bruteforce.p14500;

import java.io.IOException;

public class Main {

    static int N, M, max = Integer.MIN_VALUE;
    static int[][] A;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        N = readInt();
        M = readInt();
        A = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                A[i][j] = readInt();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                DFS(i, j, 1, A[i][j]);
                visited[i][j] = false;

                comb(0, 0, i, j, A[i][j]); //인접한 4칸 중 3칸 고르기 (ㅗ,ㅓ,ㅜ,ㅏ)
            }
        }

        System.out.println(max);
    }

    static void comb(int cnt, int start, int y, int x, int sum) {
        if (cnt == 3) {
            max = Math.max(max, sum);
            return;
        }

        for (int d = start; d < 4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];

            if (ny >= 0 && ny < N && nx >= 0 && nx < M) {
                comb(cnt + 1, d + 1, y, x, sum + A[ny][nx]);
            }
        }
    }

    static void DFS(int y, int x, int cnt, int sum) {
        if (cnt == 4) {
            max = Math.max(max, sum);
            return;
        }

        for (int d = 0; d < 4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];

            if (ny >= 0 && ny < N && nx >= 0 && nx < M && !visited[ny][nx]) {
                visited[ny][nx] = true;
                DFS(ny, nx, cnt + 1, sum + A[ny][nx]);
                visited[ny][nx] = false;
            }
        }
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
