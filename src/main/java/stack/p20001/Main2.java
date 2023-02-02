package stack.p20001;

import java.io.*;

public class Main2 {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();

        int ans = 0;
        String question;

        do {
            question = br.readLine();
            if (question.equals("문제")) ans += 1;
            else if (question.equals("고무오리")) {
                if (ans == 0) {
                    ans += 2;
                }
                else ans -= 1;
            }
        } while (!question.equals("고무오리 디버깅 끝"));

        if (ans != 0) System.out.println("힝구");
        else System.out.println("고무오리야 사랑해");
    }

    public static void main(String[] args) throws Exception {
        new Main2().solution();
    }

}
