package two_pointer.p2559;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] temp = new int[N];
        for (int i = 0; i < N; i++)
            temp[i] = Integer.parseInt(st.nextToken());

        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= N - K; i++) {
            int sum = 0;
            for (int j = 0; j < K; j++) {
                sum += temp[i + j];
            }
            if (max < sum) max = sum;
        }

        System.out.println(max);
    }

}
