package math.p10950;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        int T = readInt();

        while (T-- > 0)
            System.out.println(readInt() + readInt());
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
