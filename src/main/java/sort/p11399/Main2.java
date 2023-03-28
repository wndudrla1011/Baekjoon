package sort.p11399;

import java.io.IOException;

public class Main2 {

    public static void main(String[] args) throws IOException {
        int N = readInt();

        int[] A = new int[N];
        int[] S = new int[N];

        for (int i = 0; i < N; i++) A[i] = readInt();

        for (int i = 1; i < N; i++) {
            int insertion_point = i;
            int insertion_value = A[i];
            for (int j = i - 1; j >= 0; j--) {
                if (A[j] < A[i]) {
                    insertion_point = j + 1;
                    break;
                }
                if (j == 0) insertion_point = 0;
            }
            for (int j = i; j > insertion_point; j--) {
                A[j] = A[j - 1];
            }
            A[insertion_point] = insertion_value;
        }

        S[0] = A[0];
        for (int i = 1; i < N; i++) {
            S[i] = S[i - 1] + A[i];
        }

        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += S[i];
        }

        System.out.println(sum);
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c  = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
