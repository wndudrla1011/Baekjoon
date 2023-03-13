package hash_map.p1269;

import java.io.IOException;
import java.util.*;

public class Main2 {

    public static void main(String[] args) throws IOException {
        int A = readInt();
        int B = readInt();

        Set<Integer> a = new HashSet<>();
        for (int i = 0; i < A; i++) a.add(readInt());

        int intersection = 0;
        for (int j = 0; j < B; j++) {
            if (a.contains(readInt())) intersection++;
        }

        System.out.println(A + B - 2 * intersection);
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
