package graph.p1325;

import java.io.IOException;
import java.util.*;

public class Main2 {

    static boolean[] visited;
    static int[] depth_A;
    static ArrayList<Integer>[] A;
    static int N, M, depth;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        N = readInt(); //컴퓨터 대수
        M = readInt(); //간선 수
        depth_A = new int[N + 1]; //각 노드로부터 최대 깊이
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
            BFS(i);
            depth_A[i] = depth;
            max = Math.max(max, depth);
        }

        for (int i = 1; i <= N; i++) {
            if (max == depth_A[i])
                sb.append(i).append(" ");
        }

        System.out.println(sb);
    }

    static void BFS(int v) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        visited[v] = true;
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int i : A[node]) {
                if (!visited[i]) {
                    visited[i] = true;
                    q.offer(i);
                    depth++;
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
