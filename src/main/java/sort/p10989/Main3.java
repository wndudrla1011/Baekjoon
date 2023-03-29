package sort.p10989;

import java.io.*;

public class Main3 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[10001];

        for (int i = 0; i < N; i++) {
            A[Integer.parseInt(br.readLine())]++;
        }

        br.close();

        for (int i = 1; i < A.length; i++) { //0은 자연수 아님
            if (A[i] != 0)
                bw.write((i + "\n").repeat(A[i]));
        }

        bw.flush();
        bw.close();
    }

}
