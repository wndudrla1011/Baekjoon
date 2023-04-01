package binary_search.p1300;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        int N = readInt();
        int K = readInt();
        long start = 1, end = K;
        long ans = 0;

        //이분 탐색
        while (start <= end) {
            long mid = (start + end) / 2;
            long cnt = 0; //중앙값보다 작은 수의 개수
            for (int i = 1; i <= N; i++) { //중앙값보다 작은 수 카운팅
                cnt += Math.min(mid / i, N);
            }
            if (cnt < K) { //중앙값보다 우측에 B[K] 존재
                start = mid + 1;
            } else { //중앙값보다 좌측에 B[K] 존재
                ans = mid;
                end = mid - 1;
            }
        }

        System.out.println(ans);
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
