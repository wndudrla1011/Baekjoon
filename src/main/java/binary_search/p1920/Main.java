package binary_search.p1920;

import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int N = readInt();
        int[] arrN = new int[N];
        for (int i = 0; i < N; i++) arrN[i] = readInt();

        int M = readInt();
        int[] arrM = new int[M];
        for (int i = 0; i < M; i++) arrM[i] = readInt();

        Arrays.sort(arrN);

        int left, right;
        for (int m : arrM) {
            left = 0; right = N - 1;
            if (m > arrN[N - 1] || m < arrN[0]) {
                sb.append(0).append('\n');
                continue;
            }
            while (left < right) {
                int mid = (left + right) / 2;
                if (arrN[mid] < m) left = mid + 1;
                else if (arrN[mid] >= m) {
                    right = mid;
                    if (arrN[mid] == m) break;
                }
            }
            if (arrN[right] == m) sb.append(1).append('\n');
            else sb.append(0).append('\n');
        }

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
