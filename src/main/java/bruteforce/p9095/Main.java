package bruteforce.p9095;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int[] dp = new int[11];
        int T = readInt();
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i <= 10; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3]; //점화식
        }

        while (T-- > 0) {
            int n = readInt();
            sb.append(dp[n]).append('\n');
        }

        System.out.println(sb);
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
