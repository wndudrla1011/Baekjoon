package hash_map.p2002;

import java.io.*;
import java.util.*;

public class Main3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] startCars = new String[N];
        for (int i = 0; i < N; i++) startCars[i] = br.readLine();

        String[] endCars = new String[N];
        for (int i = 0; i < N; i++) endCars[i] = br.readLine();

        int sIdx = 0, eIdx = 0;
        Set<String> set = new HashSet<>(); //추월 차량들
        for (; sIdx < N; sIdx++) {
            if (set.contains(startCars[sIdx])) continue; //추월한 차량이므로 조사 대상x
            for (; eIdx < N; eIdx++) {
                if (startCars[sIdx].equals(endCars[eIdx])) { //동일 차량
                    eIdx++;
                    break;
                }
                set.add(endCars[eIdx]);
            }
        }

        System.out.println(set.size());
    }

}
