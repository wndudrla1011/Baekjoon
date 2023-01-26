package two_pointer.p2467;

import java.io.*;

public class Main2 {

    public void solution() throws Exception {
        int n = nextInt();

        long[] liquid = new long[n];
        for (int i = 0; i < n; i++) liquid[i] = nextInt();

        long minFromZero = Long.MAX_VALUE;

        int resultL = 0, resultR = 0;
        for (int i = 0; i < n - 1; i++) {
            int left = i + 1;
            int right = n - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                long sum = Math.abs(liquid[i] + liquid[mid]);

                if (minFromZero > sum) {
                    minFromZero = sum;
                    resultL = i;
                    resultR = mid;
                }

                if (liquid[mid] < -liquid[i]) left = mid + 1;
                else right = mid - 1;
            }
        }

        System.out.println(liquid[resultL] + " " + liquid[resultR]);
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
