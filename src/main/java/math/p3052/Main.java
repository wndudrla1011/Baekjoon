package math.p3052;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        int[] check = new int[42];

        while ((input = br.readLine()) != null && !input.isEmpty()) {
            int num = Integer.parseInt(input);
            check[num % 42]++;
        }

        int cnt = 0;
        for (int i = 0; i < check.length; i++)
            if (check[i] != 0) cnt++;

        System.out.println(cnt);
    }

}
