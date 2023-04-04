package graph.p2606;

import java.io.IOException;
import java.util.*;

public class Main {

    static int cnt; //감염 대수
    static boolean[] visited;
    static int N, M;
    static ArrayList<Integer>[] A;

    public static void main(String[] args) throws IOException {
        N = readInt(); //컴퓨터 개수
        M = readInt(); //엣지 개수
        visited = new boolean[N + 1];
        A = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int s = readInt();
            int e = readInt();
            A[s].add(e);
            A[e].add(s);
        }

        BFS(1);

        System.out.println(cnt);
    }

    static void BFS(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int i : A[node]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                    cnt++;
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
