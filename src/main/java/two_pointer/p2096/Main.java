package two_pointer.p2096;

import java.io.*;

public class Main {

    public void solution() throws Exception {
        int n = nextInt();

        int[] max = new int[3];
        int[] min = new int[3];

        for (int i = 0; i < n; i++) {
            int x1 = nextInt();
            int x2 = nextInt();
            int x3 = nextInt();

            if (i == 0) {
                max[0] = min[0] = x1;
                max[1] = min[1] = x2;
                max[2] = min[2] = x3;
            } else {
                int beforeMax_0 = max[0], beforeMax_2 = max[2];
                max[0] = Math.max(max[0], max[1]) + x1;
                max[2] = Math.max(max[1], max[2]) + x3;
                max[1] = Math.max(Math.max(beforeMax_0, max[1]), beforeMax_2) + x2;

                int beforeMin_0 = min[0], beforeMin_2 = min[2];
                min[0] = Math.min(min[0], min[1]) + x1;
                min[2] = Math.min(min[1], min[2]) + x3;
                min[1] = Math.min(Math.min(beforeMin_0, min[1]), beforeMin_2) + x2;
            }
        }

        System.out.print(Math.max(max[0], Math.max(max[1], max[2])) + " ");
        System.out.println(Math.min(min[0], Math.min(min[1], min[2])));

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
