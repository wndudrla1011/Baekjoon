package math.p2869;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        int A = readInt();
        int B = readInt();
        int V = readInt();

        int day = (V - B) / (A - B);
        if ((V - B) % (A - B) != 0) day++;

        System.out.println(day);
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
