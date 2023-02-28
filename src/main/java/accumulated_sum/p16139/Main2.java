package accumulated_sum.p16139;

import java.io.*;
import java.util.StringTokenizer;

public class Main2 {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[][] S = new int[str.length() + 1][26];

        int row = 1;
        for (char c : str.toCharArray()) {
            System.arraycopy(S[row - 1], 0, S[row], 0, 26);
            S[row++][c - 97]++;
        }

        int q = Integer.parseInt(br.readLine());
        while (q-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char target = st.nextToken().charAt(0);
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            sb.append(S[end + 1][target - 97] - S[start][target - 97]).append('\n');
        }

        System.out.println(sb);
    }

}
