package sort.p1517;

import java.io.*;
import java.util.*;

public class Main {

    public static int[] A, tmp;
    public static long result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        A = new int[N + 1];
        tmp = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        result = 0;
        merge_sort(1, N);

        System.out.println(result);
    }

    private static void merge_sort(int s, int e) {
        if (e - s < 1) return;
        int m = (s + e) / 2;

        merge_sort(s, m);
        merge_sort(m + 1, e);

        if (e - s + 1 >= 0) System.arraycopy(A, s, tmp, s, e - s + 1);

        int k = s;
        int index1 = s;
        int index2 = m + 1;

        while (index1 <= m && index2 <= e) { //두 그룹을 Merge 해주는 로직
            if (tmp[index1] > tmp[index2]) {
                A[k++] = A[index2++];
                result += index2 - k; //뒷쪽 데이터 값이 더 작은 경우에만 swap 수행
            } else {
                A[k++] = A[index1++];
            }
        }

        for (int i = 0; i <= m - index1; i++) {
            A[i + k] = tmp[i + index1];
        }
    }

}