package queue.p2164;

import java.io.IOException;
import java.util.*;

public class Main3 {

    public static void main(String[] args) throws IOException {
        int N = readInt();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        boolean order = false;
        while (queue.size() > 1) {
            if (!order) {
                queue.poll();
            } else {
                int tmp = queue.poll();
                queue.offer(tmp);
            }
            order = !order;
        }

        System.out.println(queue.poll());
    }

    static int readInt() throws IOException {
        int val = 0;
        do {
            int c = System.in.read();
            if (c == ' ' || c == '\n') break;
            val = 10 * val + c - 48;
        } while (true);
        return val;
    }

}
