package stack.p1874;

import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        int first = Integer.parseInt(br.readLine());
        for (int i = 1; i <= first; i++) {
            stack.push(i);
            sb.append("+").append('\n');
        }

        int last = stack.pop(); //이전 최댓값 -> 다음 push 때, 시작 값 지정
        sb.append("-").append('\n');

        String input;
        while ((input = br.readLine()) != null && !input.isEmpty()) {
            int num = Integer.parseInt(input);
            if (last > num) { //해당 값이 스택에 존재
                if (num != stack.peek()) { //값이 존재하지만, 순서가 맞지 않은 경우
                    sb.setLength(0);
                    sb.append("NO\n");
                    break;
                }
                stack.pop();
                sb.append("-").append('\n');
            } else { //해당 값이 스택에 존재x
                for (int i = last + 1; i <= num; i++) {
                    stack.push(i);
                    sb.append("+").append('\n');
                }
                last = stack.pop();
                sb.append("-").append('\n');
            }
        }

        System.out.println(sb);
    }

}