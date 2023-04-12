package graph.p13549;

import java.io.IOException;
import java.util.*;

public class Main3 {

    /*
    * 값의 2배인 경우는 가중치가 0이므로 K를 넘더라도 이동한다.
    * 따라서, time 은 최대 범위의 2배인 200,000까지 체크하도록 한다.
    * */
    static int[] time = new int[200001]; //시간 값 저장
    static Deque<Integer> deque = new ArrayDeque<>();
    static int N, K; //N : 수빈, K : 동생

    public static void main(String[] args) throws IOException {
        N = readInt();
        K = readInt();

        BFS();
    }

    static void BFS() {
        deque.offer(N);
        time[N] = 1;

        while (!deque.isEmpty()) {
            int now = deque.poll();

            if (now == K) {
                System.out.println(time[K] - 1);
                return;
            }

            //가중치가 0인 경로이므로 pos > K 라도 최소가 나올 수 있다.
            if (now * 2 <= 200000 && time[now * 2] == 0) {
                time[now * 2] = time[now];
                deque.offerFirst(now * 2);
            }

            if (now - 1 >= 0 && time[now - 1] == 0) {
                time[now - 1] = time[now] + 1;
                deque.offer(now - 1);
            }

            //가중치가 1인 경로이므로 pos >= K 이면 최소가 나올 수 없다.
            if (now < K && now + 1 <= 100000 && time[now + 1] == 0) {
                time[now + 1] = time[now] + 1;
                deque.offer(now + 1);
            }
        }
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
