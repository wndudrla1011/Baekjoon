package hash_map.p3077;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> naval_battle = new LinkedHashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) naval_battle.put(st.nextToken(), i);

        int total_case = N * (N - 1) / 2;
        int[] ans = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            String s = st.nextToken();
            ans[i] = naval_battle.get(s);
        }

        int score = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (ans[j] > ans[i]) score++;
            }
        }

        System.out.println(score + "/" + total_case);
    }

}
