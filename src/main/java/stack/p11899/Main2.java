package stack.p11899;

import java.io.*;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        short left = 0;
        short right = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') left++;
            else {
                if (left == 0) right++;
                else left--;
            }
        }

        System.out.println(left + right);
    }

}
