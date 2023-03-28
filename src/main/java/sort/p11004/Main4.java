package sort.p11004;

import java.io.*;
import java.util.*;

public class Main4 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());

        quickSort(A, 0, N - 1, K - 1);
        System.out.println(A[K - 1]);
    }

    public static void quickSort(int[] A, int S, int E, int K) {
        if (S < E) {
            int pivot = partition(A, S, E);
            if (pivot == K)
                return;
            else if (K < pivot) //K가 pivot보다 왼쪽에 있으므로, 왼쪽 그룹만 정렬
                quickSort(A, S, pivot - 1, K);
            else //K가 pivot보다 오른쪽에 있으므로, 오른쪽 그룹만 정렬
                quickSort(A, pivot + 1, E, K);
        }
    }

    public static int partition(int[] A, int S, int E) {
        if (S + 1 == E) {
            if (A[S] > A[E]) swap(A, S, E);
            return E;
        }

        int M = (S + E) / 2;
        swap(A, S, M); //pivot 값과 첫 번째 값 교환 --> 좌우 포인터 이동을 편하게 하기 위함
        int pivot = A[S];
        int i = S + 1, j = E;

        while (i <= j) {
            while (pivot < A[j] && j > 0) j--; //피벗보다 작은 수가 나올 때까지
            while (pivot > A[i] && i < A.length - 1) i++; //피벗보다 큰 수가 나올 때까지
            if (i <= j) swap(A, i++, j--); //조건을 만족한 두 값을 swap
        }

        A[S] = A[j];
        A[j] = pivot;

        return j;
    }

    public static void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

}
