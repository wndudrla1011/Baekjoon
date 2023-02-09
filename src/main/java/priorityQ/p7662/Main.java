package priorityQ.p7662;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> treeMap = new TreeMap<>(); //값, 해당 원소 개수

            while (k-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if (command.equals("D")) {
                    if (treeMap.isEmpty()) continue;
                    int target = num == -1 ? treeMap.firstKey() : treeMap.lastKey();
                    int cnt = treeMap.get(target); //중복 원소 개수
                    if (cnt == 1) treeMap.remove(target); //중복이 없으므로 제거
                    else treeMap.merge(target, -1, Integer::sum); //중복이 있으므로 감소 후 재삽입
                }
                else if (command.equals("I")) treeMap.merge(num, 1, Integer::sum);
            }

            if (treeMap.isEmpty()) sb.append("EMPTY").append('\n');
            else sb.append(treeMap.lastKey()).append(" ").append(treeMap.firstKey()).append('\n');

        }

        System.out.println(sb);
    }

}