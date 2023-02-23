package string.p6550;

import java.io.*;
import java.util.StringTokenizer;

public class Main2 {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String input;
        while ((input = br.readLine()) != null && !input.isEmpty()) {
            st = new StringTokenizer(input);
            char[] s = st.nextToken().toCharArray();
            char[] t = st.nextToken().toCharArray();

            int idx = 0;
            for (char c : t) {
                if (idx >= s.length) {
                    break;
                }
                if (s[idx] == c) idx++;
            }

            if (idx == s.length) sb.append("Yes").append('\n');
            else sb.append("No").append('\n');
        }

        System.out.println(sb);
    }

}
