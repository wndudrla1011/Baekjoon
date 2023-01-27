package two_pointer.p10025;

import java.io.*;
import java.util.Arrays;

public class Main {

    public void solution() throws Exception {
        int n = nextInt();
        int k = nextInt();

        int[] g = new int[n];
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            g[i] = nextInt();
            x[i] = nextInt();
        }

        int[] stage = new int[1000001];
        for (int i = 0; i < n; i++) stage[x[i]] = g[i]; //좌표 + 얼음 통합

        Arrays.sort(x); //x 좌표 범위만 보기 위해 정렬
        int max = Integer.MIN_VALUE, sum = 0;
        int left = x[0] - k, right = x[0] + k;

        //초기 윈도우 생성
        for (int i = x[0]; i <= right; i++) if (i < stage.length) sum += stage[i];
        for (int i = x[0]; i >= left; i--) if (i >= 0) sum += stage[i];
        sum -= stage[x[0]]; //중복 덧셈

        //슬라이딩 윈도우 진행
        for (int i = x[0] + 1; i <= x[n - 1]; i++) {
            if (right + 1 < stage.length) sum += stage[++right];
            if (left >= 0) sum -= stage[left];
            ++left;

            max = Math.max(max, sum);
        }

        System.out.println(max);
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
