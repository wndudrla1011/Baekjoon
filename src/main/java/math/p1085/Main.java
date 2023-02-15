package math.p1085;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        int x = readInt();
        int y = readInt();
        int w = readInt();
        int h = readInt();

        System.out.println(Math.min(h - y, Math.min(y, Math.min(x, w - x))));
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read())>32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
