package bruteforce.p15649;

import java.io.IOException;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static boolean[] visited;
    static int[] A;

    public static void main(String[] args) throws IOException {
        N = readInt();
        M = readInt();
        A = new int[M];
        visited = new boolean[N + 1];
        DFS(0);

        System.out.println(sb);
    }

    static void DFS(int count) {
        if (count == M) {
            for (int v : A)
                sb.append(v).append(" ");
            sb.append('\n');
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                A[count] = i;
                DFS(count + 1);
                visited[i] = false;
            }
        }
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
