package math.p10952;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input;

        while ((input = br.readLine()) != null) {
            int A = input.charAt(0) - '0';
            int B = input.charAt(2) - '0';
            if (A == 0 || B == 0) break;
            sb.append(A + B).append('\n');
        }

        System.out.println(sb);
    }
}
