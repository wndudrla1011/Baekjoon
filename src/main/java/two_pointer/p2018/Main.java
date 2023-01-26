package two_pointer.p2018;

import java.io.*;

public class Main {

    public void solution() throws Exception {
        int n = nextInt();

        int cnt = 0, left = 0, right = 0, sum = 0;
        while (left <= n) {
            while (++right <= n) {
                sum += right;
                if (sum >= n) {
                    if (sum == n) cnt++;
                    break;
                }
            }
            while (++left <= n) {
                sum -= left;
                if (sum <= n) {
                    if (sum == n) cnt++;
                    break;
                }
            }
        }

        System.out.println(cnt);
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
