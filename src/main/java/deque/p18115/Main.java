package deque.p18115;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Deque<Integer> init = new ArrayDeque<>();
        int tmp;

        int[] skills = new int[N + 1];
        for (int i = N; i > 0; i--) skills[i] = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            if (skills[i] == 1) init.offerFirst(i);
            else if (skills[i] == 2) {
                tmp = init.pollFirst();
                init.offerFirst(i);
                init.offerFirst(tmp);
            }
            else init.offer(i);
        }

        while (!init.isEmpty()) sb.append(init.pollFirst()).append(" ");
        System.out.println(sb);
    }

}
