package two_pointer.p1940;

import java.io.IOException;
import java.util.Arrays;

public class Main3 {

    public static void main(String[] args) throws IOException {
        int N = readInt();
        int M = readInt();

        int[] A = new int[N];
        for (int i = 0; i < N; i++) A[i] = readInt();

        Arrays.sort(A);

        int cnt = 0, left = 0, right = N - 1;
        while (left < right) {
            if (A[left] + A[right] < M) left++;
            else if (A[left] + A[right] > M) right--;
            else {
                left++;
                right--;
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
