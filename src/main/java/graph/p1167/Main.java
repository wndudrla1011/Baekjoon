package graph.p1167;

import java.io.*;
import java.util.*;

public class Main {

    static boolean[] visited;
    static ArrayList<Node>[] A;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        int N = readInt();
        A = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        distance = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        //그래프 정보 저장
        for (int i = 1; i <= N; i++) {
            int start = readInt(); //출발 노드
            int edge; //간선 정보
            while ((edge = readInt()) > 0) {
                int dist = readInt(); //거리
                A[start].add(new Node(edge, dist));
            }
        }

        BFS(1);
        int Max = 1;

        for (int i = 2; i <= N; i++) {
            if (distance[Max] < distance[i])
                Max = i;
        }

        distance = new int[N + 1];
        visited = new boolean[N + 1];

        BFS(Max);

        Arrays.sort(distance);

        System.out.println(distance[N]);
    }

    static void BFS(int index) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(index);
        visited[index] = true;
        while (!queue.isEmpty()) {
            int now_node = queue.poll();
            for (Node i : A[now_node]) {
                int e = i.e;
                int v = i.weight;
                if (!visited[e]) {
                    visited[e] = true;
                    queue.add(e);
                    distance[e] = distance[now_node] + v;
                }
            }
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

class Node {
    int e;
    int weight;

    public Node(int e, int weight) {
        this.e = e;
        this.weight = weight;
    }
}