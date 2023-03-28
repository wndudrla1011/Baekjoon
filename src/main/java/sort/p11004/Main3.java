package sort.p11004;

import java.io.*;
import java.util.StringTokenizer;

public class Main3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());

        pivot_sort(A, 0, N - 1);

        System.out.println(A[K - 1]);
    }

    private static void pivot_sort(int[] A, int lo, int hi) {
        if (lo >= hi) return;

        int pivot = partition(A, lo, hi);

        pivot_sort(A, lo, pivot);
        pivot_sort(A, pivot + 1, hi);
    }

    private static int partition(int[] A, int left, int right) {
        int lo = left - 1;
        int hi = right + 1;
        int pivot = A[(left + right) / 2];

        while (true) {
            do {
                lo++;
            } while (A[lo] < pivot);

            do {
                hi--;
            } while (A[hi] > pivot && lo <= hi);

            if (lo >= hi) return hi;

            swap(A, lo, hi);
        }
    }

    private static void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

}
