package two_pointer.p15565;

import java.io.*;
import java.util.*;

public class Main2 {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NK = br.readLine().split(" ");
        int N = Integer.parseInt(NK[0]);
        int K = Integer.parseInt(NK[1]);
        String dolls = br.readLine();
        List<Integer> lionIndex = new ArrayList<>(); //lion 의 index 저장
        for (int i = 0; i < N; i++)
            if (dolls.charAt(i * 2) == '1') lionIndex.add(i); //공백 포함되어 들어오므로

        int numLion = lionIndex.size();
        if (numLion < K) { //조건을 만족하는 최소 집합 불가능
            System.out.println(-1);
            return;
        }

        if (numLion == K) { //lion 개수가 K와 같다면 경우의 수는 1가지
            System.out.println(lionIndex.get(K - 1) - lionIndex.get(0) + 1);
            return;
        }

        int min = (int) 1e9;
        int start = 0;
        int end = K - 1;
        while (end < numLion) {
            min = Math.min(min, lionIndex.get(end) - lionIndex.get(start) + 1);
            ++start;
            ++end;
        }

        System.out.println(min);
    }

    public static void main(String[] args) throws Exception {
        new Main2().solution();
    }
}
