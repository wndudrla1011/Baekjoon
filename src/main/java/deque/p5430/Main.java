package deque.p5430;

import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        Deque<Integer> deque;
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String commands = br.readLine();
            int N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine(), "[],");
            deque = new ArrayDeque<>();

            for (int j = 0; j < N; j++) deque.add(Integer.parseInt(st.nextToken()));

            AC(deque, commands);
        }

        System.out.println(sb);
    }

    public static void AC(Deque<Integer> deque, String commands) {
        boolean isRight = true; //방향 변수

        for (char command : commands.toCharArray()) {
            if (command == 'R') isRight = !isRight;
            else { //명령 D
                if (isRight) { //정방향
                    if (deque.pollFirst() == null) {
                        sb.append("error\n");
                        return;
                    }
                }
                else { //역방향
                    if (deque.pollLast() == null) {
                        sb.append("error\n");
                        return;
                    }
                }
            }
        }

        parsingResult(deque, isRight); //출력 배열 만들기
    }

    private static void parsingResult(Deque<Integer> deque, boolean isRight) {
        sb.append("[");

        if (deque.size() > 0) {
            if (isRight) { //정방향
                sb.append(deque.pollFirst());
                while (!deque.isEmpty()) {
                    sb.append(",").append(deque.pollFirst());
                }
            }
            else { //역방향
                sb.append(deque.pollLast());
                while (!deque.isEmpty()) {
                    sb.append(",").append(deque.pollLast());
                }
            }
        }

        sb.append("]").append('\n');
    }

}