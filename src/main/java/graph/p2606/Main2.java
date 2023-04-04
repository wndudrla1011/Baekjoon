package graph.p2606;

import java.io.IOException;

public class Main2 {

    static int cnt; //감염 대수
    static boolean[] visited;
    static int N, M;
    static boolean[][] A;

    public static void main(String[] args) throws IOException {
        N = readInt(); //컴퓨터 개수
        M = readInt(); //엣지 개수
        visited = new boolean[N + 1];
        A = new boolean[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            int s = readInt();
            int e = readInt();
            A[s][e] = A[e][s] = true;
        }

        System.out.println(DFS(1));
    }

    static int DFS(int i) {
        visited[i] = true;

        for (int j = 1; j <= N; j++) {
            if (isPossible(i, j)) {
                cnt++;
                DFS(j);
            }
        }

        return cnt;
    }

    static boolean isPossible(int a, int b) {
        return A[a][b] && !visited[b];
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
