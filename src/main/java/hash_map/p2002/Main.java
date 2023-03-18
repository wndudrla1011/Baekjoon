package hash_map.p2002;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;

        Map<String, Integer> entrance = new LinkedHashMap<>();
        for (int i = 0; i < N; i++) entrance.put(br.readLine(), i);

        Map<String, Integer> exit = new LinkedHashMap<>();
        for (int i = 0; i < N; i++) exit.put(br.readLine(), i);

        for (Map.Entry<String, Integer> ex : exit.entrySet()) {
            String target = ex.getKey(); //조사 차량
            for (Map.Entry<String, Integer> ent : entrance.entrySet()) {
                int ent_num = entrance.get(target); //입장 순번
                if (ent.getValue() < ent_num) { //입구에서 자신보다 앞섰던 차량
                    if (exit.get(ent.getKey()) > exit.get(target)) { //출구에서 자신보다 뒤처진 경우
                        cnt++;
                        break;
                    }
                }
            }
        }

        System.out.println(cnt);
    }

}
