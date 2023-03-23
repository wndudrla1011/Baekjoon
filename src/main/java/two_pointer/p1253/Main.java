package two_pointer.p1253;

import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        int N = readInt();
        int cnt = 0;

        int[] A = new int[N];
        for (int i = 0; i < N; i++) A[i] = readInt();

        Arrays.sort(A);

        int left, right;
        for (int i = 0; i < N; i++) {
            left = 0;
            right = N - 1;
            while (left < right) {
                if (left == i || right == i) {
                    if (left == i) left++;
                    if (right == i) right--;
                    continue;
                }
                if (A[left] + A[right] > A[i]) right--;
                else if (A[left] + A[right] < A[i]) left++;
                else {
                    cnt++;
                    break;
                }
            }
        }

        System.out.println(cnt);
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
