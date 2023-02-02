package queue.p2161;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main2 {

    public void solution() throws Exception {
        int n = nextInt();

        int[] card = new int[3000];
        int top = 1;
        int bottom = n + 1;

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) card[i] = i;

        for (int i = 1; i <= n; i++) {
            sb.append(card[top]).append(" ");
            card[top++] = 0;
            card[bottom++] = card[top++];
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        initFI();
        new Main2().solution();
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
