package hash_map.p9612;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        int max = 0;
        String result = "";
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (max <= entry.getValue()) {
                if (max == entry.getValue()) {
                    if (result.compareTo(entry.getKey()) < 0) result = entry.getKey();
                    continue;
                }
                max = entry.getValue();
                result = entry.getKey();
            }
        }

        System.out.println(result + " " + max);
    }

}
