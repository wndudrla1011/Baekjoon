package math.p2753;

import java.io.IOException;

public class Main {

    public void solution() throws Exception {
        int year = readInt();

        if (year % 4 == 0) {
            if (year % 100 > 0 || year % 400 == 0) System.out.println(1);
            else System.out.println(0);
        }
        else System.out.println(0);
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
