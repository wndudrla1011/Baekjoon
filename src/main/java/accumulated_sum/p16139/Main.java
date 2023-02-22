package accumulated_sum.p16139;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        int[][] check = new int[S.length()][26]; //행: S의 각 문자열 위치, 열: a-z 알파벳
        check[0][S.charAt(0) - 'a']++; //누적 식 세우기 위해 0번째 별도 체크

        for (int i = 1; i < S.length(); i++) {
            int tmp = S.charAt(i) - 'a';
            for (int j = 0; j < 26; j++) {
                check[i][j] = check[i - 1][j]; //수직 방향 누적
            }
            check[i][tmp]++; //현재 값 체크
        }

        int q = Integer.parseInt(br.readLine());
        while (q-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char target = st.nextToken().charAt(0);
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            if (l == 0) sb.append(check[r][target - 'a']).append('\n'); //0에서 시작하는 경우
            else sb.append(check[r][target - 'a'] - check[l - 1][target - 'a']).append('\n'); //0이 아닌 곳에서 시작하는 경우
        }

        System.out.println(sb);
    }

}
