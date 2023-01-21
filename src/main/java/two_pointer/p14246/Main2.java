package two_pointer.p14246;

import java.io.*;
import java.util.*;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());

        long answer = 0;

        for (int i = 0; i < arr.length; i++) {
            long sum = 0;
            int j = i;
            while (j < arr.length) {
                sum += arr[j];
                if (sum > k) {
                    answer += arr.length - j;
                    break;
                }
                else j++;
            }
        }

        System.out.println(answer);
        br.close();
    }

}
