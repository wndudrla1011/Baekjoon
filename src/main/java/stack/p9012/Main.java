package stack.p9012;

import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        Stack<Character> stack;

        op:while (T-- > 0) {
            String input = br.readLine();
            stack = new Stack<>();

            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == '(') stack.push(input.charAt(i));
                else {
                    if (stack.isEmpty()) {
                        sb.append("NO").append('\n');
                        continue op;
                    }
                    else stack.pop();
                }
            }

            if (stack.isEmpty()) sb.append("YES").append('\n');
            else sb.append("NO").append('\n');
        }

        System.out.println(sb);
    }

}
