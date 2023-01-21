package two_pointer.p2003;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer = 0, sum = 0;
        int start = 0, end = 0;
        int N, M;

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        while (true) {
            if (sum >= M)
                sum -= arr[start++];
            else if (end >= N)
                break;
            else
                sum += arr[end++];

            if (sum == M)
                answer++;
        }

        System.out.println(answer);

    }

}
