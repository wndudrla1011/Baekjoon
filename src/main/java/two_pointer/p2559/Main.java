package two_pointer.p2559;

import java.io.*;

public class Main {

    public void solution() throws Exception {
        int n = nextInt();
        int k = nextInt();

        int[] temp = new int[n];
        for (int i = 0; i < n; i++) temp[i] = nextInt();

        int sum = 0, max = 0;
        for (int i = 0; i < k; i++) sum += temp[i];

        max = sum;

        for (int i = 1; i <= n - k; i++) {
            sum = 0;
            for (int j = i; j < i + k; j++) sum += temp[j];
            max = Math.max(max, sum);
        }

        System.out.println(max);
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