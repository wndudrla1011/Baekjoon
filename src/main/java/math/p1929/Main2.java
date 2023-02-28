package math.p1929;

import java.io.IOException;

public class Main2 {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int M = readInt();
        int N = readInt();

        boolean[] prime = new boolean[N + 1];

        for (int i = 2; i <= N; i++) {
            if (prime[i]) continue;
            if (i >= M) sb.append(i).append('\n');
            for (int j = i + i; j <= N; j += i) prime[j] = true;
        }

        System.out.println(sb);
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
