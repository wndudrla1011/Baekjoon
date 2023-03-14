package hash_map.p3077;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> naval_battle = new LinkedHashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) naval_battle.put(st.nextToken(), i);

        int total_case = N * (N - 1) / 2;
        String[] ans = new String[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) ans[i] = st.nextToken();

        int score = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (naval_battle.get(ans[i]) < naval_battle.get(ans[j])) score++;
            }
        }

        System.out.println(score + "/" + total_case);
    }

}
