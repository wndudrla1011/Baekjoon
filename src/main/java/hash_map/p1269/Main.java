package hash_map.p1269;

import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        int A = readInt();
        int B = readInt();

        Map<Integer, Boolean> map_A = new HashMap<>();
        for (int i = 0; i < A; i++) map_A.put(readInt(), true);

        Map<Integer, Boolean> map_B = new HashMap<>();
        for (int i = 0; i < B; i++) map_B.put(readInt(), true);

        //A-B
        int a_b = 0;
        for (Map.Entry<Integer, Boolean> entry : map_A.entrySet()) {
            if (!map_B.containsKey(entry.getKey())) a_b++;
        }

        //B-A
        int b_a = 0;
        for (Map.Entry<Integer, Boolean> entry : map_B.entrySet()) {
            if (!map_A.containsKey(entry.getKey())) b_a++;
        }

        System.out.println(a_b + b_a);
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
