package two_pointer.p10025;

import java.io.*;

public class Main2 {

    private static int MAX = 1000001;

    public void solution() throws Exception {
        int n = nextInt();
        int k = nextInt();

        int sum, max = 0, d = (k << 1) + 1;
        int[] ice = new int[MAX];
        for (int i = 0; i < n; i++) {
            int g = nextInt();
            int x = nextInt();
            ice[x] = g;
            if (max < x) max = x;
        }

        if (d >= MAX) d = MAX;
        MAX = max + 1;
        sum = 0;

        for (int i = 0; i < d; i++) sum += ice[i];

        max = sum;

        if (d < MAX) {
            for (int i = d; i < MAX; i++) {
                sum = sum - ice[i - d] + ice[i];
                if (max < sum) max = sum;
            }
        }

        System.out.println(max);
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
