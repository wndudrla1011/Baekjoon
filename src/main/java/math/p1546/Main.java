package math.p1546;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int max = Arrays.stream(arr).max().getAsInt();
        double score = 0;

        for (int i = 0; i < N; i++) {
            score += ((double) arr[i] / max) * 100;
        }

        System.out.println(score / N);
    }

}
