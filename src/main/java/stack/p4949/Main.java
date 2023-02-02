package stack.p4949;

import java.io.*;
import java.util.Stack;

public class Main {

    static Stack<String> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = "";

        while (true) {
            s = br.readLine();

            if (s.equals(".")) break;

            sb.append(solution(s)).append('\n');

            stack.clear();
        }

        System.out.println(sb);
    }

    private static String solution(String s) {
        String[] tmp = s.split("");
        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i].equals("(")) stack.push(tmp[i]);
            if (tmp[i].equals("[")) stack.push(tmp[i]);
            if (tmp[i].equals(")")) {
                if (!stack.isEmpty() && stack.peek().equals("(")) stack.pop();
                else return "no";
            }
            if (tmp[i].equals("]")) {
                if (!stack.isEmpty() && stack.peek().equals("[")) stack.pop();
                else return "no";
            }
        }
        if (stack.isEmpty()) return "yes";
        else return "no";
    }

}
