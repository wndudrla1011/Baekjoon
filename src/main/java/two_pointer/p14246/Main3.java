package two_pointer.p14246;

import java.io.*;

public class Main3 {

    public void solution() throws Exception {
        int n = nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = nextInt();

        int k = nextInt();

        int left = 0, right = 0;
        long sum = 0, ans = 0;

        while (left <= n - 1) {
            sum += arr[right++];
            if (sum > k) {
                ans += (n - right + 1);
                left++;
                right = left;
                sum = 0;
            }
            if (right >= n) break;
        }

        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        initFI();
        new Main3().solution();
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
