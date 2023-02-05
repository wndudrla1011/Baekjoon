package math.p1978;

import java.io.*;

public class Main2 {

    public static void main(String[] args) throws IOException {
        int N = readInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = readInt();

        int cnt = 0;

        op:for (int i = 0; i < arr.length; i++) {
            int range = arr[i];

            if (range == 1) continue;

            for (int j = 2; j <= range; j++)
                if (range % j == 0 && range != j) continue op;

            cnt++;
        }

        System.out.println(cnt);
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
