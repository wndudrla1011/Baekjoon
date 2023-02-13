package math.p2884;

import java.io.IOException;

public class Main {

    public void solution() throws Exception {
        StringBuilder sb = new StringBuilder();
        int H = readInt();
        int M = readInt();

        if (M - 45 < 0) {
            H -= 1;
            M = M - 45 + 60;
        }
        else M -= 45;

        if (H < 0) H += 24;

        sb.append(H).append(" ").append(M).append('\n');
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
