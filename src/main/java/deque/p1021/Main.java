package deque.p1021;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        LinkedList<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= N; i++) deque.offer(i);

        int[] targets = new int[M];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) targets[i] = Integer.parseInt(st.nextToken());

        int cnt = 0;
        for (int t : targets) {
            int pos = deque.indexOf(t);
            int half_pos;

            if (deque.size() % 2 == 0) half_pos = deque.size() / 2 - 1;
            else half_pos = deque.size() / 2;

            if (pos <= half_pos) { //OP 2 : 앞을 뒤로
                for (int i = 0; i < pos; i++) {
                    Integer tmp = deque.pollFirst();
                    deque.offerLast(tmp);
                    cnt++;
                }
            }
            else { //OP 3 : 뒤를 앞으로
                for (int i = 0; i < deque.size() - pos; i++) {
                    Integer tmp = deque.pollLast();
                    deque.offerFirst(tmp);
                    cnt++;
                }
            }
            deque.pollFirst(); //OP 1
        }

        System.out.println(cnt);
    }

}
