package two_pointer.p20922;

import java.io.*;

public class Main {

    public void solution() throws Exception {
        int n = nextInt();
        int k = nextInt();

        long[] ch = new long[100001];
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = nextInt();

        long len = 0, max = Long.MIN_VALUE;
        int j = 1, next = 1;
        for (int i = 0; i < n;) {
            if (i == 0) {
                ch[arr[i]]++;
                len = 1;
            }
            else if (i > 0 && next <= n) len++; //next 는 종료 지점 다음부터 시작하므로 len 1 부족함
            if (next > n) break; //n까지 갔다면 더 이상 최장 길이는 나오지 않음
            for (j = next; j < n; j++) {
                ch[arr[j]]++;
                if (ch[arr[j]] > k) {
                    max = Math.max(max, len); //변경 전에 len 값 저장
                    //최장 길이를 얻으려면 종료된 숫자가 k 이하가 되도록 해야 한다.
                    while (ch[arr[j]] > k) {
                        ch[arr[i++]]--;
                        len--;
                    }
                    break;
                }
                len++;
            }
            next = j + 1; //다음 위치 저장
            max = Math.max(max, len); //n까지 수행한 경우 저장을 못했으므로 저장
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
