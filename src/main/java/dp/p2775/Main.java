package dp.p2775;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        int T = readInt(); // testcases
        int k, n; // k층 n호
        int[][] APT = new int[15][15];

        for (int i = 0; i < 15; i++) {
            APT[i][1] = 1; // i층 1호
            APT[0][i] = i; // 0층 i호
        }

        for (int i = 1; i < 15; i++) { // 1 ~ 14층
            for (int j = 2; j < 15; j++) { // 2 ~ 14호
                APT[i][j] = APT[i - 1][j] + APT[i][j - 1];
            }
        }

        while (T-- > 0) {
            k = readInt();
            n = readInt();
            System.out.println(APT[k][n]);
        }
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
