package accumulated_sum.p10986;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        int N = readInt();
        int M = readInt();
        long result = 0; //M으로 나누어 떨어지는 (i,j) 쌍의 개수

        long[] acc = new long[N + 1]; //합배열
        long[] cnt = new long[M]; //같은 나머지의 인덱스를 카운트하는 배열 (% M 이므로 0~(M-1) 가능)

        for (int i = 1; i <= N; i++) {
            acc[i] = (acc[i - 1] + readInt()) % M;
            if (acc[i] == 0) result++; //M으로 나누어 떨어진다면 0이다
            cnt[(int) acc[i]]++; //나머지가 같은 인덱스 카운팅
        }

        /*
        * acc[j] % M == acc[i-1] % M 을 만족하는 (i,j) 쌍을 결과값에 더한다.
        * 즉, cnt[i](i가 나머지인 인덱스의 수)에서 2가지를 뽑는 경우의 수 카운팅
        * */
        for (int i = 0; i < M; i++) {
            if (cnt[i] > 1) //인덱스가 같은 쌍 존재
                result += (cnt[i] * (cnt[i] - 1) / 2);
        }

        System.out.println(result);
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
