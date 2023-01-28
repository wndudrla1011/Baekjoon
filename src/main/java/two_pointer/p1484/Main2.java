package two_pointer.p1484;

import java.io.*;
import java.util.*;

public class Main2 {

    public void solution() throws Exception {
        int G = nextInt();

        List<Integer> factors = new ArrayList<>();
        for (int i = 1; i < Math.sqrt(G); i++)
            if (G % i == 0) factors.add(i);

        int[] arr = new int[factors.size()];
        for (int i = 0; i < arr.length; i++) {
            if ((factors.get(i) + (G / factors.get(i))) % 2 == 0) {
                arr[i] = ((factors.get(i) + (G / factors.get(i))) / 2);
            }
        }

        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[arr.length - 1 - i] != 0)
                System.out.println(arr[arr.length - 1 - i]);
            else cnt += 1;
        }

        if (cnt == arr.length) System.out.println(-1);
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
