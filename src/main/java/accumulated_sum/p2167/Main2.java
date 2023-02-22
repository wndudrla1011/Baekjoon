package accumulated_sum.p2167;

import java.io.IOException;

public class Main2 {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int N = readInt();
        int M = readInt();
        int[][] arr = new int[N + 1][M + 1];

        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= M; c++) {
                arr[r][c] = arr[r - 1][c] + arr[r][c - 1] - arr[r - 1][c -  1] + readInt();
            }
        }

        int K = readInt();
        while (K-- > 0) {
            int i = readInt();
            int j = readInt();
            int x = readInt();
            int y = readInt();

            sb.append(arr[x][y] - arr[i - 1][y] - arr[x][j - 1] + arr[i - 1][j - 1]).append('\n');
        }

        System.out.print(sb);
    }

    static int readInt() throws IOException {
        int n = 0;
        boolean isNegative = false;
        while (true) {
            int input = System.in.read();
            if (input <= 32) {
                return isNegative ? n * -1 : n;
            } else if (input == '-')
                isNegative = true;
            else
                n = (n << 3) + (n << 1) + (input & 15);
        }
    }

}