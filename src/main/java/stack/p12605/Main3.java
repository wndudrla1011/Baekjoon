package stack.p12605;

import java.io.*;
import java.util.*;

public class Main3 {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Stack<String> stack = new Stack<>();

        for (int i = 1; i <= N; i++) {
            sb.append("Case #").append(i).append(": ");
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) stack.push(st.nextToken());
            while (!stack.isEmpty()) sb.append(stack.pop()).append(" ");
            sb.append('\n');
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main3().solution();
    }

}
