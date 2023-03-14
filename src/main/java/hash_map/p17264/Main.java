package hash_map.p17264;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());

        Map<String, Integer> info = new HashMap<>();
        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            String player = st.nextToken();
            String WL = st.nextToken();

            if (WL.equals("W")) info.put(player, W);
            else info.put(player, -L);
        }

        int score = 0;
        while (N-- > 0) {
            String member = br.readLine();
            score += info.getOrDefault(member, -L);
            if (score < 0) score = 0;
            if (score >= G) {
                System.out.println("I AM NOT IRONMAN!!");
                return;
            }
        }

        System.out.println("I AM IRONMAN!!");
    }

}
