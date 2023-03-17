package hash_map.p16165;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Set<String>> girl_group = new HashMap<>();
        while (N-- > 0) {
            String teamName = br.readLine();
            int num = Integer.parseInt(br.readLine());
            while (num-- > 0) {
                String member = br.readLine();
                Set<String> set = girl_group.getOrDefault(teamName, new TreeSet<>());
                set.add(member);
                girl_group.put(teamName, set);
            }
        }

        while (M-- > 0) {
            String question = br.readLine();
            int type = Integer.parseInt(br.readLine());
            if (type == 0) { //멤버 이름 출력
                Set<String> members = girl_group.get(question);
                for (String member : members) {
                    sb.append(member).append('\n');
                }
            } else { //팀 이름 출력
                for (Map.Entry<String, Set<String>> entry : girl_group.entrySet()) {
                    String affiliation = entry.getKey();
                    boolean flag = false;
                    for (String value : entry.getValue()) {
                        if (value.equals(question)) {
                            sb.append(affiliation).append('\n');
                            flag = true;
                            break;
                        }
                    }
                    if (flag) break;
                }
            }
        }

        System.out.println(sb);
    }

}
