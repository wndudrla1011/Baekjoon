package queue.p2164;

import java.io.IOException;

public class Main2 {

    public static void main(String[] args) throws IOException {
        int N = readInt();
        int i = 1;
        while (i < N) i <<= 1;
        System.out.println(i == 1 ? 1 : (N - (i >> 1) << 1));
    }

    static int readInt() throws IOException {
        int val = 0;
        do {
            int c = System.in.read();
            if (c == ' ' || c == '\n') break;
            val = 10 * val + c - 48;
        } while (true);
        return val;
    }

}
