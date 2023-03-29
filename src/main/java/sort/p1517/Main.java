package sort.p1517;

import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        int N = readInt();

        Node[] A = new Node[N];

        for (int i = 0; i < N; i++) {
            A[i] = new Node(readInt(), i);
        }

        Arrays.sort(A);
        int max = 0;

        for (int i = 0; i < N; i++) {
            if (max < A[i].index - i)
                max = A[i].index - i;
        }

        System.out.println(max + 1);
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

class Node implements Comparable<Node> {
    int value;
    int index;

    public Node(int value, int index) {
        this.value = value;
        this.index = index;
    }

    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }
}