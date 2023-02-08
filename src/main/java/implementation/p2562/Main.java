package implementation.p2562;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        int idx = 0, max = Integer.MIN_VALUE;
        for (int i = 1; i <= 9; i++) {
            int x = readInt();
            if (max < x) {
                max = x;
                idx = i;
            }
        }

        System.out.println(max);
        System.out.println(idx);
    }

    static int readInt() throws IOException {
        int n = 0;
        boolean isNegative = false;
        while (true) {
            int input = System.in.read();
            if (input <= 32) {
                return isNegative ? n * -1 : n;
            } else if (input == '-')
                isNegative = true;
            else
                n = (n << 3) + (n << 1) + (input & 15);
        }
     }

}
