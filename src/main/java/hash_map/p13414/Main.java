package hash_map.p13414;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Map<String, Integer> waiting = new HashMap<>();
        for (int i = 0; i < L; i++) {
            waiting.put(br.readLine(), i);
        }

        String[] result = new String[L];
        for (Map.Entry<String, Integer> entry : waiting.entrySet()) {
            result[entry.getValue()] = entry.getKey();
        }

        for (int i = 0; i < result.length; i++) {
            if (result[i] != null) {
                sb.append(result[i]).append('\n');
                K--;
            }
            if (K == 0) break;
        }

        System.out.println(sb);
    }

}
