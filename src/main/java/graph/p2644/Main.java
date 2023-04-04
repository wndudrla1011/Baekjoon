package graph.p2644;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    static boolean[] visited;
    static ArrayList<Integer>[] A;
    static int end, kinship, cnt;

    public static void main(String[] args) throws IOException {
        int n = readInt();
        int start = readInt();
        end = readInt();
        int m = readInt();
        visited = new boolean[n + 1];
        A = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int x = readInt();
            int y = readInt();
            A[x].add(y);
            A[y].add(x);
        }

        DFS(start);

        if (visited[end]) System.out.println(kinship);
        else System.out.println(-1);
    }

    static void DFS(int v) {
        visited[v] = true;
        if (v == end) {
            kinship = cnt;
            return;
        }
        for (int i : A[v]) {
            if (!visited[i]) {
                cnt++;
                DFS(i);
                cnt--;
            }
        }
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
