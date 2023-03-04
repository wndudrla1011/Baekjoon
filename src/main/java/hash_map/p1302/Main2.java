package hash_map.p1302;

import java.io.*;
import java.util.*;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> accounts = new HashMap<>();
        String ans = "";
        int max = Integer.MIN_VALUE;
        while (N-- > 0) {
            String title = br.readLine();
            int num = accounts.getOrDefault(title, 0) + 1;
            accounts.put(title, num);

            if ((num > max) || (max == num && title.compareTo(ans) < 0)) {
                max = num;
                ans = title;
            }
        }

        bw.write(ans);
        br.close();
        bw.flush();
        bw.close();
    }

}