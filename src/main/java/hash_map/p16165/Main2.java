package hash_map.p16165;

import java.io.*;
import java.util.*;

public class Main2 {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, String> memberMatch = new HashMap<>();
        Map<String, TreeSet<String>> teamMatch = new HashMap<>();
        while (N-- > 0) {
            String teamName = br.readLine();
            int num = Integer.parseInt(br.readLine());
            TreeSet<String> set = new TreeSet<>();
            while (num-- > 0) {
                String member = br.readLine();
                set.add(member);
                memberMatch.put(member, teamName);
            }
            teamMatch.put(teamName, set);
        }

        while (M-- > 0) {
            String question = br.readLine();
            int type = Integer.parseInt(br.readLine());
            if (type == 0) { //멤버 이름 출력
                for (String s : teamMatch.get(question)) {
                    sb.append(s).append('\n');
                }
            } else { //팀 이름 출력
                sb.append(memberMatch.get(question)).append('\n');
            }
        }

        System.out.println(sb);
    }

}
