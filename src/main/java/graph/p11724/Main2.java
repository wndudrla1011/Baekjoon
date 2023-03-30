package graph.p11724;

import java.io.IOException;

public class Main2 {

    private static int N, M;
    private static int[][] A;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        N = readInt(); //노드 개수
        M = readInt(); //간선 개수
        int cnt = 0;

        A = new int[N][N]; //인접 행렬
        visited = new boolean[N]; //밤문 여부

        for (int i = 0; i < M; i++) {
            int s = readInt() - 1;
            int e = readInt() - 1;
            A[s][e] = 1; //무방향 -> 양방향 에지 저장
            A[e][s] = 1;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                DFS(i);
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    private static void DFS(int v) {
        if (visited[v]) return;

        visited[v] = true;

        for (int i = 0; i < N; i++) {
            if (A[v][i] == 1) DFS(i);
        }
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
