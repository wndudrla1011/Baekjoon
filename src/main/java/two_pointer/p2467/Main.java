package two_pointer.p2467;

import java.io.*;

public class Main {

    public void solution() throws Exception {
        int n = nextInt();

        long[] liquid = new long[n];
        for (int i = 0; i < n; i++) liquid[i] = nextInt();

        long minFromZero = Long.MAX_VALUE;

        int left = 0, right = n - 1;
        int resultL = 0, resultR = 0;
        while (left < right) {
            long sum = liquid[left] + liquid[right];

            if (minFromZero > Math.abs(sum)) {
                minFromZero = Math.abs(sum);
                resultL = left;
                resultR = right;
            }

            if (sum < 0) left++;
            else right--;
        }

        System.out.println(liquid[resultL] + " " + liquid[resultR]);
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
