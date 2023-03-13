package hash_map.p10816;

import java.io.IOException;
import java.util.*;

public class Main2 {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int N = readInt();

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int num = readInt();
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int M = readInt();
        while (M-- > 0) {
            int target = readInt();
            map.putIfAbsent(target, 0);
            sb.append(map.get(target)).append(" ");
        }

        System.out.println(sb);
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
