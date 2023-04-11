package graph.p16964;

import java.io.IOException;
import java.util.*;

public class Main {

    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static int[] Ans;
    static boolean flag;
    static int N, idx;

    public static void main(String[] args) throws IOException {
        N = readInt();
        A = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        Ans = new int[N + 1];
        flag = true;
        idx = 2;

        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            int s = readInt();
            int e = readInt();
            A[s].add(e);
            A[e].add(s);
        }

        for (int i = 1; i <= N; i++) {
            Ans[i] = readInt();
        }

        //첫 값이 1이 아니면 DFS x
        if (Ans[1] != 1) {
            System.out.println("0");
            return;
        }

        checkDFS(1);

        System.out.println(flag ? 1 : 0);
    }

    static void checkDFS(int v) {
        if (visited[Ans[v]]) {
            return;
        }

        visited[v] = true;

        HashSet<Integer> set = new HashSet<>();
        for (int i : A[v]) {
            if (!visited[i]) {
                set.add(i);
            }
        }

        if (set.size() == 0) return; //리프 노드이므로 종료

        if (set.contains(Ans[idx])) {
            checkDFS(Ans[idx++]);
        } else {
            flag = false;
        }
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
