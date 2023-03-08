package sort.p2751;

import java.io.IOException;

public class Main2 {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int N = readInt();

        /*
        * -1000000 ~ 1000000
        * 기준점 0 = index 1000000
        * */
        boolean[] arr = new boolean[2000001];
        for (int i = 0; i < N; i++) arr[readInt() + 1000000] = true;

        for (int i = 0; i < arr.length; i++)
            if (arr[i]) sb.append((i - 1000000)).append('\n');

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
