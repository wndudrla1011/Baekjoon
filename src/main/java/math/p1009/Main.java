package math.p1009;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        int T = readInt();

        while (T-- > 0) {
            int a = readInt();
            int b = readInt();

            int num = a % 10;
            int mod = b % 4;

            if (num == 0) System.out.println(10);
            else if (num == 1 || num == 5 || num == 6) System.out.println(num);
            else {
                if (mod == 0) System.out.println((int) (Math.pow(num, 4) % 10));
                else System.out.println((int) (Math.pow(num, mod) % 10));
            }
        }
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
