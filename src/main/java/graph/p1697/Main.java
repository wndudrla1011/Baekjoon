package graph.p1697;

import java.io.IOException;
import java.util.*;

public class Main {

    static int start, end;
    static boolean[] visited = new boolean[100001];

    public static void main(String[] args) throws IOException {
        start = readInt();
        end = readInt();

        System.out.println(BFS(start, 0));
    }

    static int BFS(int v, int t) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(v, t));
        visited[v] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node.val == end) { //동생 위치에 도착
                return node.timer;
            }
            int next_t = node.timer + 1; //타이머 1초 지남
            //범위 체크 + 방문 전인 경우
            if (node.val - 1 >= 0 && !visited[node.val - 1]) {
                visited[node.val - 1] = true;
                q.offer(new Node(node.val - 1, next_t));
            }
            if (node.val + 1 <= 100000 && !visited[node.val + 1]) {
                visited[node.val + 1] = true;
                q.offer(new Node(node.val + 1, next_t));
            }
            if (node.val * 2 <= 100000 && !visited[node.val * 2]) {
                visited[node.val * 2] = true;
                q.offer(new Node(node.val * 2, next_t));
            }
        }

        return -1;
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c  = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

    static class Node {
        int val;
        int timer;

        public Node(int val, int timer) {
            this.val = val;
            this.timer = timer;
        }
    }

}
