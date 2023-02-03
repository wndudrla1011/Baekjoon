package queue.p2164;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        int N = readInt();

        int[] queue = new int[1000001];
        int front = 0, rear = 0;

        for (int i = 1; i <= N; i++) queue[rear++] = i;

        while (rear - front > 1) {
            front++;
            int top = queue[front++];
            queue[rear++] = top;
        }

        System.out.println(queue[front]);
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
