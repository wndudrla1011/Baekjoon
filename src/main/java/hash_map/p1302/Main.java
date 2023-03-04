package hash_map.p1302;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> accounts = new HashMap<>();
        while (N-- > 0) {
            String title = br.readLine();
            accounts.put(title, accounts.getOrDefault(title, 0) + 1);
        }

        int max = 0;
        TreeSet<String> titles = new TreeSet<>();
        for (Map.Entry<String, Integer> entry : accounts.entrySet()) {
            if (max <= entry.getValue()) {
                if (max < entry.getValue()) titles = new TreeSet<>();
                max = entry.getValue();
                titles.add(entry.getKey());
            }
        }

        bw.write(titles.iterator().next());
        br.close();
        bw.flush();
        bw.close();
    }

}