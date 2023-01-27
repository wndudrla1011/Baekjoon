package two_pointer.p15565;

import java.io.*;
import java.util.Arrays;

public class Main {

    public void solution() throws Exception {
        int n = nextInt();
        int k = nextInt();

        int[] doll = new int[n + 1];
        for (int i = 1; i <= n; i++) doll[i] = nextInt();

        int min = Integer.MAX_VALUE;
        int left = 1, right = 1;
        int lion = 0;

        if (Arrays.stream(doll).filter(i -> i == 1).count() < k) {
            System.out.println(-1);
            return;
        }

        while (left <= right) {
            while (lion < k) {
                if (right - left >= min) break;
                if (right > n) {
                    System.out.println(min);
                    return;
                }
                if (doll[right++] == 1) lion++;
            }

            min = Math.min(min, (right - left));

            if (doll[left++] == 1) {
                if (right > n) break;
                lion--;
            } else {
                while (doll[left] == 2) left++;
            }

            if (right > n) {
                if (doll[--right] == 1) break;
                else while (doll[--right] == 2) right--;
            }
        }

        System.out.println(min);
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
