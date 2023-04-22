package graph.p13549;

import java.io.IOException;
import java.util.*;

public class Main2 {

    static boolean[] visited = new boolean[100001]; //방문 체크
    //시간 오름차순, <값, 시간> 저장
    static PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x[1]));
    static int N, K; //N : 수빈, K : 동생

    public static void main(String[] args) throws IOException {
        N = readInt();
        K = readInt();

        BFS();
    }

    static void BFS() {
        pq.offer(new int[]{N, 0});

        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int pos = now[0];
            int time = now[1];

            if (pos == K) {
                System.out.println(time);
                return;
            }

            visited[pos] = true;

            //논리적으로 pos > K 라도 최소가 나올 수 있다.
            if (pos * 2 <= 100000 && !visited[pos * 2]) {
                pq.offer(new int[]{pos * 2, time});
            }

            if (pos - 1 >= 0 && !visited[pos - 1]) {
                pq.offer(new int[]{pos - 1, time + 1});
            }

            //논리적으로 pos >= K 이면 최소가 나올 수 없다.
            if (pos < K && pos + 1 <= 100000 && !visited[pos + 1]) {
                pq.offer(new int[]{pos + 1, time + 1});
            }
        }
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
