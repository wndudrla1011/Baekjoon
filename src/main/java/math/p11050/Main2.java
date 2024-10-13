package math.p11050;

import java.io.IOException;

public class Main2 {

    static int[][] dp;

    public static void main(String[] args) throws IOException {
        int N = readInt();
        int K = readInt();
        dp = new int[N + 1][K + 1];

        System.out.println(recur(N, K));
    }

    static int recur(int N, int K) {
        if (dp[N][K] > 0) {
            return dp[N][K];
        }

        if (K == 0 || N == K) {
            return dp[N][K] = 1; // C(N, 0) or C(N, N) = 1
        }

        // C(N, K) = C(N - 1, K - 1) + C(N - 1, K)
        return dp[N][K] = recur(N - 1, K - 1) + recur(N - 1, K);
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
