package hash_map.p2002;

import java.io.*;
import java.util.*;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;

        String[] entrance = new String[N];
        for (int i = 0; i < N; i++) entrance[i] = br.readLine();

        Map<String, Integer> exit = new LinkedHashMap<>();
        for (int i = 0; i < N; i++) exit.put(br.readLine(), i);

        for (int i = 1; i < N; i++) {
            int exit_num = exit.get(entrance[i]); //퇴장 순번
            for (int j = i - 1; j >= 0; j--) { //입구에서 먼저 입장했던 차량들
                if (exit.get(entrance[j]) > exit_num) { //출구에서 자신보다 뒤쳐진 경우
                    cnt++;
                    break;
                }
            }
        }

        System.out.println(cnt);
    }

}
