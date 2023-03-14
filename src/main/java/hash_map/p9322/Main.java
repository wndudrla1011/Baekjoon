package hash_map.p9322;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            Map<String, Integer> public_key_one = new LinkedHashMap<>();
            for (int i = 0; i < n; i++) public_key_one.put(st.nextToken(), i);

            st = new StringTokenizer(br.readLine());
            int[] public_key_two = new int[n];
            for (int i = 0; i < n; i++) public_key_two[i] = public_key_one.get(st.nextToken());

            st = new StringTokenizer(br.readLine());
            String[] cipher = new String[n];
            for (int i = 0; i < n; i++) cipher[public_key_two[i]] = st.nextToken();

            for (int i = 0; i < n; i++) sb.append(cipher[i]).append(" ");
            sb.append('\n');
        }

        System.out.println(sb);
    }

}
