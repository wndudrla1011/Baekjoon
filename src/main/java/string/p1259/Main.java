package string.p1259;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        int left, right;
        while (!(input = br.readLine()).equals("0")) {
            left = 0;
            right = input.length() - 1;
            int len = sb.length();

            while (left < right) {
                if (input.charAt(left) == input.charAt(right)) {
                    left++;
                    right--;
                } else {
                    sb.append("no").append('\n');
                    break;
                }
            }

            if (sb.length() == len) sb.append("yes").append('\n');
        }

        System.out.println(sb);
    }

}
