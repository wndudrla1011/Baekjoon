package two_pointer.p3273;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int answer = 0;

        int i = 0, j = n - 1;
        Arrays.sort(arr);
        while (i < j) {
            if (arr[i] + arr[j] == x) {
                answer++;
                i++; j--;
            }
            else if (arr[i] + arr[j] < x) i++;
            else j--;
        }

        System.out.println(answer);
    }

}
