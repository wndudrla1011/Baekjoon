package two_pointer.p1806;

import java.io.*;

public class Main {

    public void solution() throws Exception {
        int n = nextInt();
        long s = nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = nextInt();

        int min = Integer.MAX_VALUE;
        int left = 0, right = 0;

        int sum = 0;
        while (true){
            if (sum >= s){
                min = Math.min(min, right - left);
                sum -= arr[left++];
            } else if (right == n) {
                break;
            } else if (sum < s){
                sum += arr[right++];
            }
        }

        if (min == Integer.MAX_VALUE)
            System.out.println(0);
        else
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
