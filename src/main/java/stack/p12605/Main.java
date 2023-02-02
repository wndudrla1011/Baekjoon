package stack.p12605;

import java.io.*;
import java.util.Stack;

public class Main {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String[] sentence = br.readLine().split(" ");
            for (String s : sentence) stack.push(s);
            while (!stack.isEmpty()) sb.append(stack.pop()).append(" ");
            System.out.println("Case #" + (i + 1) + ": " + sb);
            sb.setLength(0);
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

}
