package sort.p11399;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        int N = readInt();

        int[] A = new int[N];
        for (int i = 0; i < N; i++) A[i] = readInt();

        int target, in_pos;
        for (int i = 1; i < N; i++) {
            target = A[i];
            in_pos = -1;
            for (int j = 0; j < i; j++) {
                if (target < A[j]) {
                    in_pos = j;
                    break;
                }
            }
            if (in_pos != -1) {
                System.arraycopy(A, in_pos, A, in_pos + 1, i - in_pos);
                A[in_pos] = target;
            }
        }

        int total = A[0];
        for (int i = 1; i < N; i++) {
            A[i] = A[i - 1] + A[i];
            total += A[i];
        }

        System.out.println(total);
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c  = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
