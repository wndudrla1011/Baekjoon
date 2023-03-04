package hash_map.p1620;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> getNum = new HashMap<>();
        Map<Integer, String> getName = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            getNum.put(name, i);
            getName.put(i, name);
        }

        while (M-- > 0) {
            String quiz = br.readLine();
            if (quiz.matches("[^0-9]+$")) sb.append(getNum.get(quiz)).append('\n');
            else sb.append(getName.get(Integer.parseInt(quiz))).append('\n');
        }

        System.out.println(sb);
    }

}
