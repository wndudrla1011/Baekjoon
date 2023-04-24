package bruteforce.p2309;

import java.io.IOException;
import java.util.*;

public class Main2 {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int[] heights = new int[9];
        int sum = 0;

        for (int i = 0; i < 9; i++) {
            heights[i] = readInt();
            sum += heights[i];
        }

        op:for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if ((sum - heights[i] - heights[j] == 100)) {
                    heights[i] = heights[j] = 100;
                    break op;
                }
            }
        }

        Arrays.sort(heights);

        for (int i = 0; i < 7; i++) {
            sb.append(heights[i]).append('\n');
        }

        System.out.println(sb);
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
