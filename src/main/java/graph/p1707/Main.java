package graph.p1707;

import java.io.IOException;
import java.util.*;

public class Main {

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

            BFS();
        }

        System.out.println(sb);
    }

    static void BFS() {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= V; i++) {
            if (visited[i] == 0) {
                q.offer(i);
                visited[i] = 1;
            }

            while (!q.isEmpty()) {
                int now = q.poll();

                for (int j : A[now]) {
                    if (visited[j] == 0)
                        q.offer(j);

                    //연속으로 같은 그룹이 나타난 경우 -> 이분 그래프 x
                    if (visited[j] == visited[now]) {
                        sb.append("NO").append('\n');
                        return;
                    }

                    //방문 전 상태 인접 노드
                    if (visited[now] == 1 && visited[j] == 0) {
                        visited[j] = 2; //인접 노드가 그룹 1일 경우 2
                    } else if (visited[now] == 2 && visited[j] == 0) {
                        visited[j] = 1; //인접 노드가 그룹 2일 경우 1
                    }
                }
            }
        }

        sb.append("YES").append('\n');
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
