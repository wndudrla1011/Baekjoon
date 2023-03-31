package graph.p1167;

import java.io.*;
import java.util.ArrayList;

public class Main2 {

    static boolean[] visited;
    static ArrayList<Edge>[] A;
    static int max, node;

    public static void main(String[] args) throws IOException {
        int N = readInt();
        A = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        //그래프 정보 저장
        for (int i = 1; i <= N; i++) {
            int start = readInt();
            int edge = 0; //간선 정보
            while ((edge = readInt()) > 0) {
                A[start].add(new Edge(edge, readInt()));
            }
        }

        DFS(1, 0);

        int start = node;
        max = 0;

        visited = new boolean[N + 1];
        DFS(start, 0);

        System.out.println(max);
    }

    static void DFS(int v, int distance) {
        visited[v] = true;
        if (distance > max) {
            max = distance;
            node = v;
        }

        for (Edge next : A[v]) {
            if (!visited[next.e])
                DFS(next.e, distance + next.w);
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

class Edge {
    int e; //노드
    int w; //가중치

    public Edge(int e, int w) {
        this.e = e;
        this.w = w;
    }
}
