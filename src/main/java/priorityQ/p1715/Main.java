package priorityQ.p1715;

import java.io.IOException;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        int N = readInt();

        for (int i = 0; i < N; i++) pq.offer((long) readInt());

        long sum = 0;
        if (N >= 3) {
            while (pq.size() > 1) {
                long bundle = pq.poll() + pq.poll();
                pq.offer(bundle);
                sum += bundle;
            }
        }
        else if (N == 2) sum = pq.poll() + pq.poll();

        System.out.println(sum);
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
