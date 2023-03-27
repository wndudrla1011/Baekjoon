package sort.p1427;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] N = br.readLine().split("");
        int[] A = new int[N.length];

        for (int i = 0; i < A.length; i++) {
            A[i] = Integer.parseInt(N[i]);
        }

        int max;
        for (int i = 0; i < N.length - 1; i++) {
            max = i;
            for (int j = i + 1; j < N.length; j++) {
                if (A[max] < A[j]) {
                    max = j;
                }
            }
            if (A[i] < A[max]) {
                int tmp = A[i];
                A[i] = A[max];
                A[max] = tmp;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N.length; i++) {
            sb.append(A[i]);
        }

        System.out.println(sb);
    }

}
