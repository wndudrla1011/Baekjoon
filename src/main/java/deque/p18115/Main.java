package deque.p18115;

import java.io.*;
import java.util.*;

public class Main {

    public void solution() throws Exception {
        StringBuilder sb = new StringBuilder();
        int N = nextInt();

        int[] commands = new int[N];
        for (int i = 0; i < N; i++) commands[i] = nextInt();

        Deque<Integer> card = new ArrayDeque<>();
        for (int i = N - 1; i >= 0; i--) {
            if (commands[i] == 1) card.offerFirst(N - i);
            else if (commands[i] == 2) {
                if (card.isEmpty()) card.offerFirst(N - i);
                else {
                    int tmp = card.pollFirst();
                    card.offerFirst(N - i);
                    card.offerFirst(tmp);
                }
            }
            else card.offer(N - i);
        }

        sb.append(card.pollFirst());
        while (!card.isEmpty()) sb.append(" ").append(card.pollFirst());

        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        initFI();
        new Main().solution();
    }

    private static final int DEFAULT_BUFFER_SIZE = 1 << 16;
    private static DataInputStream inputStream;
    private static byte[] buffer;
    private static int curIdx, maxIdx;

    private static void initFI() {
        inputStream = new DataInputStream(System.in);
        buffer = new byte[DEFAULT_BUFFER_SIZE];
        curIdx = maxIdx = 0;
    }

    private static int nextInt() throws IOException {
        int ret = 0;
        byte c = read();
        while (c <= ' ') c = read();
        boolean neg = (c == '-');
        if (neg) c = read();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
        if (neg) return -ret;
        return ret;
    }

    private static byte read() throws IOException {
        if (curIdx == maxIdx) {
            maxIdx = inputStream.read(buffer, curIdx = 0, DEFAULT_BUFFER_SIZE);
            if (maxIdx == -1) buffer[0] = -1;
        }
        return buffer[curIdx++];
    }

}
