package two_pointer.p3273;

import java.io.*;

public class Main2 {

    private void solution() throws Exception {
        boolean[] v = new boolean[1000001];
        int n = nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nextInt();
            v[arr[i]] = true;
        }
        int x = nextInt();

        int answer = 0;
        for (int i = 0; i < n; i++) {
            int target = x - arr[i];
            if (target <= 0 || target > 1000000) continue;
            if (v[target]) answer++;
        }

        System.out.println(answer / 2);
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

    //숫자 입력
    private static int nextInt() throws IOException {
        int ret = 0;
        byte c = read();
        while (c <= ' ') c = read();
        boolean neg = (c == '-'); //음수 (true), 양수 (false)
        if (neg) c = read(); //음수는 neg 로 확인했으므로 읽어 넘김
        do { //입력 받은 (char) 숫자를 (int) 숫자로 만들기
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
        if (neg) return -ret; //음수라면 음수 값 반환
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
