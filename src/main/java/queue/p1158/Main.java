package queue.p1158;

import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int N = readInt();
        int K = readInt();

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) queue.add(i);

        while (!queue.isEmpty()) {
            for (int i = 0; i < K - 1; i++) {
                int tmp = queue.poll();
                queue.offer(tmp);
            }
            if (queue.size() > 1) sb.append(queue.poll()).append(", ");
            else sb.append(queue.poll()).append(">");
        }

        System.out.println(sb);
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = (System.in.read())) > 32)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
