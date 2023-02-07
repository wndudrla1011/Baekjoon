package priorityQ.p13975;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int T = readInt();
        PriorityQueue<Long> pq;

        while (T-- > 0) {
            int K = readInt();
            pq = new PriorityQueue<>();
            while (K-- > 0) pq.offer((long) readInt());

            long sum = 0;
            while (pq.size() > 1) {
                long first = pq.poll();
                long second = pq.poll();

                sum += first + second;

                pq.offer(first + second);
            }
            sb.append(sum).append('\n');
        }

        System.out.println(sb);
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
     }

}
