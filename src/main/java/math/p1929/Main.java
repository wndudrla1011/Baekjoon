package math.p1929;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int M = readInt();
        int N = readInt();

        int[] arr = new int[N + 1];
        arr[1]++;

        for (int i = 2; i <= N; i++) {
            int tmp = 2;
            while (i * tmp <= N) {
                if (arr[i * tmp] == 0) arr[i * tmp]++;
                tmp++;
            }
        }

        for (int i = M; i <= N; i++)
            if (arr[i] == 0) sb.append(i).append('\n');

        System.out.println(sb);
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
