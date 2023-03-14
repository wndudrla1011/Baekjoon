package hash_map.p9375;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            Map<String, Integer> clothes = new HashMap<>();
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                String type = st.nextToken();
                clothes.put(type, clothes.getOrDefault(type, 0) + 1);
            }

            int result = 1;
            for (int value : clothes.values()) {
                result *= (value + 1);
            }
            sb.append(result - 1).append('\n');
        }

        System.out.println(sb);
    }

}
