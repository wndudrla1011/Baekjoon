package deque.p13417;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        Deque<Character> deque = new ArrayDeque<>();

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            sb = new StringBuilder();

            deque.offer(st.nextToken().charAt(0));

            for (int i = 1; i < N; i++) {
                char alphabet = st.nextToken().charAt(0);
                if (alphabet <= deque.peekFirst()) deque.offerFirst(alphabet);
                else deque.offerLast(alphabet);
            }

            while (!deque.isEmpty()) sb.append(deque.pollFirst());
            System.out.println(sb);
        }
    }

}
