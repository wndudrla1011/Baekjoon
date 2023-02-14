package implementation.p10871;

import java.io.IOException;

public class Main {

    public void solution() throws Exception {
        StringBuilder sb = new StringBuilder();
        int N = readInt();
        int X = readInt();

        for (int i = 0; i < N; i++) {
            int num = readInt();
            if (X > num) sb.append(num).append(" ");
        }

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
