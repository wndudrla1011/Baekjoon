package two_pointer.p3078;

import java.io.*;
import java.util.*;

public class Main2 {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] student = new int[N];
        for (int i = 0; i < N; i++)
            student[i] = br.readLine().length();

        int[] friend = new int[21];
        for (int i = 0; i < K; i++) friend[student[i]]++;

        long bf = 0;
        for (int i = 0; i < N; i++) {
            friend[student[i]]--;
            if (i + K < N) friend[student[i + K]]++;
            bf += friend[student[i]];
        }

        System.out.println(bf);
    }

    public static void main(String[] args) throws Exception {
        new Main2().solution();
    }

}
