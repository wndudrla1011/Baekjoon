package two_pointer.p1940;

import java.io.*;

public class Main {

    private void solution() throws Exception {
        int n = nextInt();
        int m = nextInt();

        boolean[] ch = new boolean[100001];
        int[] material = new int[n];
        for (int i = 0; i < n; i++) {
            material[i] = nextInt();
            ch[material[i]] = true;
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            int target = m - material[i];
            if (target <= 0 || target > 100000) continue;
            if (ch[target]) answer++;
        }

        System.out.println(answer / 2);
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
