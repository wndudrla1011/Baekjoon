package stack.p10773;

import java.io.IOException;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<>();
        int K = readInt();
        int sum = 0;

        while (K-- > 0) {
            int input = readInt();
            if (input != 0) stack.push(input);
            else stack.pop();
        }

        while (!stack.isEmpty()) sum += stack.pop();

        System.out.println(sum);
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
