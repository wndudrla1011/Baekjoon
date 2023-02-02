package stack.p4949;

import java.io.*;

public class Main2 {

    static final int POINT = 46;
    static final int LEFT_PARENTHESES = 40, RIGHT_PARENTHESES = 41;
    static final int LEFT_BRACE = 91, RIGHT_BRACE = 93;
    static final String YES = "yes\n", NO = "no\n";

    public static void main(String[] args) throws IOException {
        int[] input = new int[100];
        int[] stack = new int[101];
        StringBuilder sb = new StringBuilder();

        while (true) {
            int c, len = 0, top = 0;

            while ((c = System.in.read()) > 13) input[len++] = c; //LF : 10, CR : 13

            if (len == 1 && input[0] == POINT) break;

            for (int i = 0; i < len; i++) {
                if (input[i] == LEFT_PARENTHESES || input[i] == LEFT_BRACE)
                    stack[++top] = input[i];
                else if (input[i] == RIGHT_PARENTHESES) {
                    if (stack[top] == LEFT_PARENTHESES) top--;
                    else top = -1;
                }
                else if (input[i] == RIGHT_BRACE) {
                    if (stack[top] == LEFT_BRACE) top--;
                    else top = -1;
                }
                if (top < 0) break;
            }

            sb.append(top == 0 ? YES : NO);
        }

        System.out.println(sb);
    }

}
