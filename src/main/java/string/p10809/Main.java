package string.p10809;

import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] alphabet = new int[26];

        Arrays.fill(alphabet, -1);

        String input = br.readLine();

        int idx = 0;
        for (char c : input.toCharArray()) {
            if (alphabet[c - 'a'] == -1) alphabet[c - 'a'] = idx;
            idx++;
        }

        for (int a : alphabet) sb.append(a).append(" ");

        System.out.println(sb);
    }

}
