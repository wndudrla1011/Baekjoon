package graph.p1325;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    static boolean[] visited;
    static int[] depth_A;
    static ArrayList<Integer>[] A;
    static int N, M, depth;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        N = readInt(); //컴퓨터 대수
        M = readInt(); //간선 수
        depth_A = new int[N + 1]; //각 노드로부터 최대 감염 노드 수
        A = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            int s = readInt();
            int e = readInt();
            A[e].add(s); //방향 그래프
        }

        int max = 0;
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            depth = 0;
            DFS(i, 0);
            depth_A[i] = depth;
            max = Math.max(max, depth);
        }

        for (int i = 1; i <= N; i++) {
            if (max == depth_A[i])
                sb.append(i).append(" ");
        }

        System.out.println(sb);
    }

    static void DFS(int v, int d) {
        visited[v] = true;
        for (int i : A[v]) {
            if (!visited[i]) {
                depth++; //감염 가능한 노드 카운팅
                DFS(i, d + 1);
            }
        }
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
