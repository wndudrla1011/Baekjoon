package accumulated_sum.p11969;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int N = readInt();
        int Q = readInt();

        int[][] acc = new int[N + 1][3];
        int[] count = new int[3];

        for (int i = 1; i <= N; i++) {
            count[readInt() - 1]++;
            System.arraycopy(count, 0, acc[i], 0, 3);
        }

        while (Q-- > 0) {
            int a = readInt();
            int b = readInt();

            for (int i = 0; i < 3; i++)
                sb.append(acc[b][i] - acc[a - 1][i]).append(" ");

            sb.append('\n');
        }

        System.out.println(sb);
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
