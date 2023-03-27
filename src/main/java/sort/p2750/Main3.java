package sort.p2750;

import java.io.*;

public class Main3 {

    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = readInt();

        A = new int[N];
        for (int i = 0; i < N; i++) A[i] = readInt();

        for (int i = 0; i < N - 1; i++) {
            int swapCnt = 0;
            for (int j = 0; j < N - 1 - i; j++) {
                if (A[j] > A[j + 1]) {
                    swapCnt++;
                    int tmp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = tmp;
                }
            }
            if (swapCnt == 0) break;
        }

        for (int i = 0; i < A.length; i++) {
            bw.write(A[i] + "");
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

    static void swap(int i) {
        int tmp = A[i];
        A[i] = A[i + 1];
        A[i + 1] = tmp;
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
