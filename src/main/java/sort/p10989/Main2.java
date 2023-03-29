package sort.p10989;

import java.io.*;

//계수 정렬(Counting Sort)
public class Main2 {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] counting = new int[10001]; // 0 ~ 10000 범위
        int[] result = new int[A.length];

        //값 저장 -> 카운팅
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
            counting[A[i]]++;
        }

        //합 배열
        for (int i = 1; i <= 10000; i++) {
            counting[i] += counting[i - 1];
        }

        //카운팅 정렬
        for (int i = 0; i < N; i++) {
            int value = A[i];
            counting[value]--;
            result[counting[value]] = A[i];
        }

        for (int i = 0; i < N; i++) {
            sb.append(result[i]).append('\n');
        }

        System.out.println(sb);
    }

}
