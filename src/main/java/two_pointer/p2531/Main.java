package two_pointer.p2531;

import java.io.*;

public class Main {

    private void solution() throws Exception {
        int N = nextInt();
        int d = nextInt();
        int k = nextInt();
        int c = nextInt();

        int[] sushi = new int[N];
        int[] it = new int[d + 1];
        for (int i = 0; i < N; i++) sushi[i] = nextInt();

        int cnt = 0;
        for (int i = 0; i < k; i++) {
            if (it[sushi[i]] == 0) cnt++; //아직 먹지 않은 상태
            it[sushi[i]]++; //체크
        }

        int max = cnt;
        for (int i = 1; i < N; i++) { //i : start
            if (max <= cnt) max = (it[c] == 0) ? cnt + 1 : cnt; //쿠폰 초밥 포함 여부
            int end = (i + k - 1) % N; //윈도우 크기 k 유지
            if (it[sushi[end]] == 0) cnt++; //아직 먹지 않은 상태(뒤)
            it[sushi[end]]++; //체크(뒤)
            it[sushi[i - 1]]--; //제외(앞)
            if (it[sushi[i - 1]] == 0) cnt--; //윈도우에서 제외(앞)
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
