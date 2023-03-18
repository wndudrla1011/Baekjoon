package greedy.p1885;

import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        int n = readInt();
        int k = readInt();

        int[] seq = new int[n];
        for (int i = 0; i < n; i++) {
            seq[i] = readInt();
        }


    }

    static int readInt() throws IOException {
        int c, n = 0;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
