package stack.p10773;

import java.io.IOException;

public class Main2 {

    public static void main(String[] args) throws IOException {
        int K = readInt();
        int[] stack = new int[K];
        int top = -1, input;

        while (K-- > 0) {
            if ((input = readInt()) != 0) stack[++top] = input;
            else top--;
        }

        while (top > -1) K += stack[top--];

        System.out.println(K + 1);
    }

    static int readInt() throws IOException {
        int n = 0;
        boolean isNegative = false;
        while (true) {
            int input = System.in.read();
            if (input <= 32) {
                return isNegative ? n * -1 : n;
            } else if (input == '-')
                isNegative = true;
            else
                n = (n << 3) + (n << 1) + (input & 15);
        }
     }

}
