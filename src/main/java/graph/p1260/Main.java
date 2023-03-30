package graph.p1260;

import java.io.*;
import java.util.*;

public class Main {

    static boolean[] visited;
    static ArrayList<Integer>[] A;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int N = readInt();
        int M = readInt();
        int V = readInt();
        visited = new boolean[N + 1];
        A = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        while (M-- > 0) {
            int s = readInt();
            int e = readInt();
            A[s].add(e);
            A[e].add(s);
        }

        //번호가 작은 것을 먼저 탐색하기 위해 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(A[i]);
        }

        DFS(V);
        visited = new boolean[N + 1];
        sb.append('\n');
        BFS(V);

        System.out.println(sb);
    }

    static void DFS(int v) {
        sb.append(v).append(" ");
        if (visited[v]) return;

        visited[v] = true;

        for (int i : A[v]) {
            if (!visited[i])
                DFS(i);
        }
    }

    static void BFS(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            sb.append(node).append(" ");
            for (int i : A[node]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
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
