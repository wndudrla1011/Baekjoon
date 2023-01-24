package two_pointer.p2559;

import java.io.*;
import java.util.*;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] temp = new int[N + 1];
        for (int i = 1; i <= N; i++)
            temp[i] = Integer.parseInt(st.nextToken());

        int sum = 0;
        for (int i = 1; i <= K; i++) sum += temp[i];

        int max = sum;
        for (int i = K + 1, j = 1; i <= N; i++, j++) {
            sum += temp[i] - temp[j];
            if (max < sum) max = sum;
        }

        System.out.println(max);
    }

}
