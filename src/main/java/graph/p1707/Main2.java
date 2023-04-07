package graph.p1707;

import java.io.IOException;
import java.util.*;

public class Main2 {

    /*
    * 이분 그래프 확인용 배열
    * 각 노드를 방문한 후에는 0 -> 1 or 2
    * 각 노드는 1 또는 2 그룹으로 나뉜다.
    * */
    static int[] visited;
    static ArrayList<Integer>[] A;
    static int V, E;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int K = readInt(); //테스트케이스
        while (K-- > 0) {
            V = readInt(); //정점의 개수
            E = readInt(); //간선의 개수
            visited = new int[V + 1];
            A = new ArrayList[V + 1];

            //배열 리스트 초기화
            for (int i = 1; i <= V; i++) {
                A[i] = new ArrayList<>();
            }

            //인접 리스트 저장
            for (int i = 0; i < E; i++) {
                int u = readInt();
                int v = readInt();
                A[u].add(v);
                A[v].add(u);
            }

            solve();
        }

        System.out.println(sb);
    }

    static void solve() {
        for (int i = 1; i <= V; i++) {
            if (visited[i] == 0 && DFS(i, 1)) {
                sb.append("NO").append('\n');
                return;
            }
        }
        sb.append("YES").append('\n');
    }

    static boolean DFS(int v, int c) {
        visited[v] = c;

        for (int i : A[v]) {
            if (visited[i] == c)
                return true;
            if (visited[i] == 0 && DFS(i, 3 - c))
                return true;
        }
        return false;
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
