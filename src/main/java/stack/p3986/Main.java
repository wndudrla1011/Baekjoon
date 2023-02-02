package stack.p3986;

import java.io.*;
import java.util.Stack;

public class Main {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<String> stack = new Stack<>();

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            String[] alpha = br.readLine().split("");
            for (String a : alpha) {
                if (stack.isEmpty()) stack.push(a);
                else {
                    if (stack.peek().equals(a)) stack.pop();
                    else stack.push(a);
                }
            }
            if (stack.isEmpty()) cnt++;
            else stack.clear();
        }

        System.out.println(cnt);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

}