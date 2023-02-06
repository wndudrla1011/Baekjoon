package deque.p11003;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Deque<int[]> deque = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            //덱에서 현재 값보다 큰 값들 모두 제거
            while (!deque.isEmpty() && deque.peekLast()[0] > num) deque.pollLast();

            deque.offer(new int[]{num, i});
            if (deque.peek()[1] < i - L + 1) deque.poll(); //L 윈도우 크기를 넘을 때
            bw.write(deque.peek()[0] + " ");
        }

        bw.flush();
        bw.close();
    }

}
