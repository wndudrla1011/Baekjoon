package stack.p10828;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[] stack;
    static int top = 0;
    static void push(int X) { stack[top++] = X; }
    static int pop() { return top == 0 ? -1 : stack[--top]; }
    static int size() { return top; }
    static int empty() { return top == 0 ? 1 : 0; }
    static int top() { return top == 0 ? -1 : stack[top - 1]; }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer command;

        int N = Integer.parseInt(br.readLine());
        stack = new int[N];

        while (N-- > 0) {
            command = new StringTokenizer(br.readLine());
            switch (command.nextToken()) {
                case "push":
                    push(Integer.parseInt(command.nextToken()));
                    break;
                case "pop":
                    sb.append(pop()).append('\n');
                    break;
                case "size":
                    sb.append(size()).append('\n');
                    break;
                case "empty":
                    sb.append(empty()).append('\n');
                    break;
                case "top":
                    sb.append(top()).append('\n');
                    break;
            }
        }

        System.out.println(sb);
    }

}
