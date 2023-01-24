package two_pointer.p11728;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] B = new int[M];
        for (int i = 0; i < M; i++)
            B[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(A);
        Arrays.sort(B);
        int posA = 0, posB = 0;
        List<Integer> answer = new ArrayList<>();

        while (posA < N && posB < M) {
            if (A[posA] <= B[posB]) {
                answer.add(A[posA]);
                posA++;
            }
            else {
                answer.add(B[posB]);
                posB++;
            }
        }

        while (posA < N) {
            answer.add(A[posA]);
            posA++;
        }

        while (posB < M) {
            answer.add(B[posB]);
            posB++;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < answer.size(); i++) {
            sb.append(answer.get(i) + " ");
        }

        System.out.println(sb);

    }

}
