package math.p10951;

import java.io.*;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        StringBuilder sb = new StringBuilder();

        while ((input = br.readLine()) != null && !input.isEmpty()) {
            int A = input.charAt(0) - '0';
            int B = input.charAt(2) - '0';
            sb.append(A + B).append('\n');
        }

        System.out.println(sb);
    }

}
