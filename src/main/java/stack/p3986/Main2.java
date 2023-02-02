package stack.p3986;

import java.io.*;

public class Main2 {

    static char[] stack = new char[100000];
    static int top = 0;

    static boolean empty() { return top == 0; }
    static void push(char c) { stack[top++] = c; }
    static void pop() { --top; }
    static char peek() { return stack[top - 1]; }

    public void solution() throws Exception {
        int cnt = 0;
        for (int n = readInt(); n > 0; n--) {
            do {
                char c = (char) System.in.read();
                if (c != 'A' && c != 'B') break;
                if (empty() || c != peek()) push(c);
                else if (c == peek()) pop();
            } while (true);

            if (empty()) cnt++;
            top = 0;
        }

        System.out.println(cnt);
    }

    public static void main(String[] args) throws Exception {
        new Main2().solution();
    }

    static int readInt() throws IOException {
        int val = 0;
        do {
            int c = System.in.read();
            if (c == ' ' || c == '\n') break;
            val = 10 * val + c - 48;
        } while (true);
        return val;
    }

}