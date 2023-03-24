package stack.p1874;

import java.io.*;
import java.util.Stack;

public class Main2 {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        for (int i = 0; i < n; i++) A[i] = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        int num = 1;
        boolean result = true;
        for (int i = 0; i < A.length; i++) {
            int su = A[i]; //현재 수열의 수
            if (su >= num) { //값이 같아질 때까지 push
                while (su >= num) {
                    stack.push(num++);
                    sb.append("+").append('\n');
                }
                stack.pop();
                sb.append("-").append('\n');
            } else {
                int a = stack.pop();
                if (a > su) {
                    System.out.println("NO");
                    result = false;
                    break;
                }
                else sb.append("-").append('\n');
            }
        }

        if (result) System.out.println(sb);
    }

}