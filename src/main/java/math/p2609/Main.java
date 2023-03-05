package math.p2609;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int a = readInt();
        int b = readInt();

        int gcd = gcd(a, b);
        int lcm = (a * b) / gcd;

        sb.append(gcd).append('\n').append(lcm);
        System.out.println(sb);
    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
