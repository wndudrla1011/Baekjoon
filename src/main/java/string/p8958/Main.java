package string.p8958;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
        int score, sum;

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            char[] ox = st.nextToken().toCharArray();
            sum = 0;
            score = 0;

            for (char c : ox) {
                if (c == 'O') {
                    score++;
                    sum += score;
                }
                else score = 0;
            }
            System.out.println(sum);
        }
    }

}
