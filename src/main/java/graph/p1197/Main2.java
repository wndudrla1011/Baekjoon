package graph.p1197;

import java.io.IOException;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main2 {

    static int[] U;

    public static void main(String[] args) throws IOException {
        int V = readInt();
        int E = readInt();
        Edge[] edges = new Edge[E];
        U = new int[V + 1];

        for (int i = 0; i < V; i++) { //V를 포함안해도 문제 없음
            U[i] = i;
        }

        for (int i = 0; i < E; i++) {
            int A = readInt();
            int B = readInt();
            int C = readInt();
            edges[i] = new Edge(A, B, C);
        }

        Arrays.sort(edges, 0, E);

        int edge_cnt = 0;
        int expense = 0;

        for (Edge edge : edges) {
            if (edge_cnt == V - 1) break;
            if (find(edge.s) != find(edge.e)) { //집합이 다르므로 사이클 발생x
                union(edge.s, edge.e);
                edge_cnt++;
                expense += edge.w;
            }
        }

        System.out.println(expense);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            if (a < b) U[b] = a;
            else U[a] = b;
        }
    }

    private static int find(int a) {
        if (a == U[a]) return a;
        else return U[a] = find(U[a]);
    }

    static class Edge implements Comparable<Edge> {
        int s;
        int e;
        int w;

        public Edge(int s, int e, int w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return this.w - o.w; //가중치가 작은 에지부터
        }
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