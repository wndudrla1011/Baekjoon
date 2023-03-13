package hash_map.p1972;

import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static Set<String> D_pair;
    static String input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (!(input = br.readLine()).equals("*")) {
            int limit = 1;

            if (limit + 1 >= input.length()) {
                sb.append(input).append(" is surprising.").append('\n');
                continue;
            }

            validation(limit);
        }
        System.out.println(sb);
    }

    //D-쌍 검증
    static void validation(int limit) {
        while (limit + 1 < input.length()){
            D_pair = new HashSet<>();
            StringBuilder pair;
            for (int i = 0; i + limit < input.length(); i++) {
                pair = new StringBuilder();
                pair.append(input.charAt(i)).append(input.charAt(i + limit));
                if (D_pair.contains(pair.toString())) {
                    sb.append(input).append(" is NOT surprising.").append('\n');
                    return;
                }
                else D_pair.add(pair.toString());
            }
            limit++;
        }
        sb.append(input).append(" is surprising.").append('\n');
    }

}
