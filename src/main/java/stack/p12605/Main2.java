package stack.p12605;

import java.io.*;

public class Main2 {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] sentence = br.readLine().split(" ");
            System.out.print("Case #" + (i + 1) + ": ");
            for (int j = sentence.length - 1; j >= 0; j--) {
                System.out.print(sentence[j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {
        new Main2().solution();
    }

}
