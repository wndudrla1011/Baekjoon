package hash_map.p1972;

import java.io.*;

public class Main2 {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean possible;
        boolean[][] check;

        String input;
        while (!(input = br.readLine()).equals("*")) {
            possible = true;
            for (int i = 1; i < input.length(); i++) {
                check = new boolean[26][26];
                for (int j = 0; j < input.length() - i; j++) {
                    if (!check[input.charAt(j) - 'A'][input.charAt(j + i) - 'A']) {
                        check[input.charAt(j) - 'A'][input.charAt(j + i) - 'A'] = true;
                    } else {
                        possible = false;
                        break;
                    }
                }
                if (!possible) break;
            }

            if (possible) sb.append(input).append(" is surprising.").append('\n');
            else sb.append(input).append(" is NOT surprising.").append('\n');
        }
        System.out.println(sb);
    }

}
