package stack.p3986;

import java.io.*;
import java.util.Stack;

public class Main3 {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            int len = s.length();
            char[] chars = s.toCharArray();
            int[] arr = new int[len];
            int index = 0;
            for (int j = 0; j < len; j++) {
                if (index > 0) {
                    if (arr[index - 1] == chars[j]) index--;
                    else {
                        arr[index] = chars[j];
                        index++;
                    }
                } else {
                    arr[index] = chars[j];
                    index++;
                }
            }

            if (index == 0) cnt++;
        }

        System.out.println(cnt);
    }

    public static void main(String[] args) throws Exception {
        new Main3().solution();
    }

}