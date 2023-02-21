package accumulated_sum.p11441;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int N = readInt();

        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) arr[i] = readInt() + arr[i - 1];

        int M = readInt();
        int sum;
        while (M-- > 0) {
            int i = readInt();
            int j = readInt();

            sum = arr[j] - arr[i - 1];

            sb.append(sum).append('\n');
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
