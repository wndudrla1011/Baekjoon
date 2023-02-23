package string.p6550;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String input;
        while ((input = br.readLine()) != null && !input.isEmpty()) {
            st = new StringTokenizer(input);
            String s = st.nextToken();
            String t = st.nextToken();
            check(s, t);
        }

        System.out.println(sb);
    }

    private static void check(String s, String t) {
        boolean flag;
        for (int i = 0; i < s.length(); i++) {
            flag = false;
            for (int j = 0; j < t.length(); j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    t = t.substring(j + 1);
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                sb.append("No").append('\n');
                return;
            }
        }
        sb.append("Yes").append('\n');
    }

}
