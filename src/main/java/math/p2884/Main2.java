package math.p2884;

import java.io.IOException;

public class Main2 {

    public void solution() throws Exception {
        StringBuilder sb = new StringBuilder();
        int H = readInt();
        int M = readInt();

        H *= 60;
        int time = H + M - 45;

        H = time / 60;
        M = time - H * 60;

        if (M < 0) {
            M += 60;
            H = 23;
        }

        sb.append(H).append(" ").append(M).append('\n');
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main2().solution();
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
