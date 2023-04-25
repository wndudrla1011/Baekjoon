package bruteforce.p1476;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        int year = 1;
        int e = 1, s = 1, m = 1;
        int E = readInt();
        int S = readInt();
        int M = readInt();

        while (e != E || s != S || m != M) {
            e++; s++; m++; year++;

            if (e > 15) e = e % 16 + 1;
            if (s > 28) s = s % 29 + 1;
            if (m > 19) m = m % 20 + 1;
        }

        System.out.println(year);
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
