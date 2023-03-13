package hash_map.p10816;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int N = readInt();

        int[] numbers = new int[20000001];
        for (int i = 0; i < N; i++) numbers[readInt() + 10000000]++;

        int M = readInt();
        while (M-- > 0) sb.append(numbers[readInt() + 10000000]).append(" ");

        System.out.println(sb);
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
