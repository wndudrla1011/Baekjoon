package stack.p20001;

import java.io.*;
import java.util.Stack;

public class Main {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();

        Stack<String> stack = new Stack<>();
        String question;

        do {
            question = br.readLine();
            if (question.equals("문제")) stack.push(question);
            else if (question.equals("고무오리")) {
                if (stack.isEmpty()) {
                    stack.push(question);
                    stack.push(question);
                }
                else stack.pop();
            }
        } while (!question.equals("고무오리 디버깅 끝"));

        if (!stack.isEmpty()) System.out.println("힝구");
        else System.out.println("고무오리야 사랑해");
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

}
