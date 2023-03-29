package sort.p10989;

import java.io.*;

//기수 정렬(Radix Sort)
public class Main {

    static int[] A;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        A = new int[N];

        int max = 0;
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            A[i] = Integer.parseInt(input);
            if (max < input.length()) max = input.length();
        }

        radix_sort(A, max); //A[i] 의 최댓값 10000

        for (int i = 0; i < N; i++) {
            sb.append(A[i]).append('\n');
        }

        System.out.println(sb);
    }

    public static void radix_sort(int[] A, int max_size) {
        int[] output = new int[A.length]; //임시 정렬을 위한 배열
        int jarisu = 1; //현재 자릿수
        int count = 0;

        while (count != max_size) {
            int[] bucket = new int[10]; //현재 자릿수들의 분포를 합 배열의 형태로 알려 주는 배열

            for (int i = 0; i < A.length; i++)
                bucket[(A[i] / jarisu) % 10]++; //1의 자리부터 시작

            for (int i = 1; i < 10; i++)
                bucket[i] += bucket[i - 1]; //합 배열을 이용하여 index 계산

            for (int i = A.length - 1; i >= 0; i--) { //현재 자릿수를 기준으로 정렬
                bucket[(A[i] / jarisu) % 10]--;
                output[bucket[(A[i] / jarisu % 10)]] = A[i];
            }

            //다음 자릿수를 이동하기 위해 현재 자릿수 기준 정렬 데이터 저장하기
            System.arraycopy(output, 0, A, 0, A.length);

            jarisu *= 10;
            count++;
        }
    }

}
