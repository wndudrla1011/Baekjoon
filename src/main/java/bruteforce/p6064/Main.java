package bruteforce.p6064;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int T = readInt();

        while (T-- > 0) {
            int M = readInt();
            int N = readInt();
            int x = readInt() - 1;
            int y = readInt() - 1;
            boolean flag = false;

            for (int i = x; i < (M * N); i += M) {
                if (i % N == y) {
                    sb.append(i + 1).append('\n');
                    flag = true;
                    break;
                }
            }

            if (!flag) sb.append(-1).append('\n');
        }

        System.out.println(sb);
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
