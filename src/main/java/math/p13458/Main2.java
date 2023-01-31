package math.p13458;

import java.io.DataInputStream;
import java.io.IOException;

public class Main2 {

    public void solution() throws Exception {
        int n = nextInt();

        int[] candidates = new int[n];
        for (int i = 0; i < n; i++) candidates[i] = nextInt();

        int b = nextInt();
        int c = nextInt();

        long min_supervisor = 0;

        for (int i = 0; i < n; i++) {
            if (candidates[i] <= b) { //부 감독관이 필요x
                min_supervisor += 1;
            }
            else {
//                min_supervisor += 1;
                min_supervisor += Math.max(candidates[i] - b, 0) / c + ((candidates[i] - b) % c == 0 ? 1 : 2);
            }
        }

        System.out.println(min_supervisor);
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