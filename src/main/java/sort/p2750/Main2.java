package sort.p2750;

import java.io.IOException;

public class Main2 {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int N = readInt();

        int[] arr = new int[N];
        int[] counting = new int[2001]; //-1000~1000
        int[] result = new int[N];

        for (int i = 0; i < N; i++)
            arr[i] = readInt();

        for (int i = 0; i < N; i++)
            counting[arr[i] + 1000]++;

        for (int i = 1; i < counting.length; i++)
            counting[i] += counting[i - 1];

        for (int i = N - 1; i >= 0; i--) {
            int value = arr[i];
            counting[value + 1000]--;
            result[counting[value + 1000]] = value;
        }

        for (int r : result) sb.append(r).append('\n');
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
