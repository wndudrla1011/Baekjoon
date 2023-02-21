package dp.p11660;

import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int N = readInt();
        int M = readInt();

        int[][] arr = new int[N + 1][N + 1];
        int[][] dp = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i][0] = arr[i - 1][N];
            for (int j = 1; j <= N; j++) {
                arr[i][j] = readInt();
                dp[i][j] = arr[i][j] + dp[i][j - 1];
            }
        }

        int sum;
        while (M-- > 0) {
            int x1 = readInt();
            int y1 = readInt();
            int x2 = readInt();
            int y2 = readInt();

            sum = 0;
            for (int i = x1; i <= x2; i++) {
                sum += dp[i][y2] - dp[i][y1 - 1];
            }

            sb.append(sum).append('\n');
        }

        System.out.println(sb);
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
