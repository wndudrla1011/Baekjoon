package stack.p11899;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();
        char[] stack = new char[chars.length];
        int top = 0;

        for (char c : chars) {
            if (c == ')') {
                if (top > 0 && stack[top - 1] == '(') {
                    top--;
                    continue;
                }
                stack[top++] = c;
            }
            else stack[top++] = c;
        }

        System.out.println(top);
    }

}
