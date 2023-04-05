package graph.p2644;

import java.io.IOException;
import java.util.*;

public class Main2 {

    static boolean[] visited;
    static int[][] A;
    static int n, end;

    public static void main(String[] args) throws IOException {
        n = readInt();
        int start = readInt();
        end = readInt();
        int m = readInt();
        visited = new boolean[n + 1];
        A = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            int x = readInt();
            int y = readInt();
            A[x][y] = A[y][x] = 1;
        }

        System.out.println(BFS(start));
    }

    static int BFS(int v) {
        Queue<Integer> q = new LinkedList<>();
        int[] kinship = new int[n + 1];
        q.offer(v);
        int i, node;
        visited[v] = true;
        kinship[v] = 0;
        while (!q.isEmpty()) {
            node = q.poll();
            for (i = 1; i <= n; i++) {
                if (A[node][i] == 1 && !visited[i]) {
                    kinship[i] = kinship[node] + 1;
                    q.offer(i);
                    visited[i] = true;
                    if (i == end) return kinship[i];
                }
            }
        }

        return -1;
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
