package graph.p1753;

import java.io.IOException;
import java.util.*;

public class Main {

    static int V, E;
    static boolean[] visited;
    static int[] D;
    static ArrayList<Node>[] A;
    static PriorityQueue<Node> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        V = readInt();
        E = readInt();
        A = new ArrayList[V + 1];
        D = new int[V + 1];
        visited = new boolean[V + 1];
        int start = readInt();

        for (int i = 1; i <= V; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i <= V; i++) {
            D[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < E; i++) {
            int u = readInt(); //출발
            int v = readInt(); //도착
            int w = readInt(); //가중치
            A[u].add(new Node(v, w));
        }

        pq.add(new Node(start, 0));
        D[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll(); //현재 노드
            int cur_v = cur.e; //현재 정점
            if (visited[cur_v]) continue;
            visited[cur_v] = true;
            //인접 리스트 탐색
            for (Node node : A[cur_v]) {
                int next = node.e; //인접 노드
                int value = node.weight; //가중치
                if (D[cur_v] + value < D[next]) {
                    D[next] = D[cur_v] + value; //최단 거리 갱신
                    pq.add(new Node(node.e, D[next]));
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            if (visited[i]) System.out.println(D[i]);
            else System.out.println("INF"); //방문 못함 == 도달x
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

class Node implements Comparable<Node> {
    int e;
    int weight;

    public Node(int e, int weight) {
        this.e = e;
        this.weight = weight;
    }

    //우선순위 큐 -> 가중치 작은 값 우선
    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }
}