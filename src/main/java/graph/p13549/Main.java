package graph.p13549;

import java.io.IOException;
import java.util.*;

public class Main {

    static int[] time = new int[100001]; //각 인덱스는 현재 시간을 저장
    static int N, K; //N : 수빈, K : 동생

    public static void main(String[] args) throws IOException {
        N = readInt();
        K = readInt();

        BFS();
    }

    static void BFS() {
        Queue<Integer> q = new LinkedList<>();
        time[N] = 1;
        q.offer(N);

        while (!q.isEmpty()) {
            int now = q.poll();

            int next; //다음 값
            for (int i = 0; i < 3; i++) {
                if (i == 0) next = now - 1;
                else if (i == 1) next = now + 1;
                else next = now * 2;

                if (next < 0 || next > 100000) continue;

                //방문 전이거나 최소 시간으로 갱신해야 할 때
                if (i == 0 || i == 1) {
                    if (time[next] == 0 || time[next] > time[now] + 1) { //가중치 1
                        time[next] = time[now] + 1;
                        q.offer(next);
                    }
                }

                if (i == 2) {
                    if (time[next] == 0 || time[next] > time[now]) { //가중치 2
                        time[next] = time[now];
                        q.offer(next);
                    }
                }
            }
        }

        System.out.println(time[K] - 1);
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
