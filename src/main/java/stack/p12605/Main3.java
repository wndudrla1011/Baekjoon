package stack.p12605;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main3 {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer strTo;

        int n = Integer.parseInt(br.readLine());

        Stack<String> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            strTo = new StringTokenizer(s, " ");
            while (strTo.hasMoreTokens()) stack.push(strTo.nextToken());

            sb.append("Case #" + (i + 1) + ": ");

            while (!stack.isEmpty()) sb.append(stack.pop() + " ");
            sb.append('\n');
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main3().solution();
    }

}
