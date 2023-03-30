package graph.p11724;

import java.io.IOException;
import java.util.*;

public class Main {

    private static ArrayList<Integer>[] A;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        int N = readInt(); //노드 개수
        int M = readInt(); //간선 개수
        int cnt = 0;

        A = new ArrayList[N + 1]; //인접 리스트
        visited = new boolean[N + 1]; //밤문 여부

        //노드마다 연결리스트 달기
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int s = readInt();
            int e = readInt();
            A[s].add(e); //무방향 -> 양방향 에지 저장
            A[e].add(s);
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                cnt++;
                DFS(i);
            }
        }

        System.out.println(cnt);
    }

    private static void DFS(int v) {
        if (visited[v]) return;

        visited[v] = true;

        for (int i : A[v]) {
            if (!visited[i]) DFS(i);
        }
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
