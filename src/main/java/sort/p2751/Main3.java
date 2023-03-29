package sort.p2751;

import java.io.*;

public class Main3 {

    public static int[] A, tmp;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        A = new int[N + 1];
        tmp = new int[N + 1];


        for (int i = 1; i <= N; i++) A[i] = Integer.parseInt(br.readLine());

        merge_sort(1, N);

        for (int i = 1; i <= N; i++) {
            sb.append(A[i]).append("\n");
        }

        System.out.println(sb);
    }

    private static void merge_sort(int s, int e) {
        if (e - s < 1) return; //s == e 이므로 정렬x
        int m = (e + s) / 2;

        merge_sort(s, m);
        merge_sort(m + 1, e);

        if (e - s + 1 >= 0) System.arraycopy(A, s, tmp, s, e - s + 1);

        int k = s; //결과 배열의 저장 포인터
        int index1 = s; //앞쪽 그룹의 시작점
        int index2 = m + 1; //뒷쪽 그룹의 시작점

        //두 그룹을 병합
        while (index1 <= m && index2 <= e) {
            //두 그룹의 값 중 작은 값부터 A 배열에 순서대로 넣는다.
            if (tmp[index1] > tmp[index2])
                A[k++] = tmp[index2++];
            else
                A[k++] = tmp[index1++];
        }

        //한쪽 그룹이 모두 선택된 후 남아 있는 값 정리
        while (index1 <= m) A[k++] = tmp[index1++];
        while (index2 <= e) A[k++] = tmp[index2++];
    }

}
