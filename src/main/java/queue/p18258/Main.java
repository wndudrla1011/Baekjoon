package queue.p18258;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();

        StringTokenizer command;

        while (N-- > 0) {
            command = new StringTokenizer(br.readLine(), " ");
            switch (command.nextToken()) {
                case "push":
                    deque.offer(Integer.parseInt(command.nextToken()));
                    break;
                case "pop":
                    Integer item = deque.poll();
                    if (item == null) sb.append(-1).append('\n');
                    else sb.append(item).append('\n');
                    break;
                case "size":
                    sb.append(deque.size()).append('\n');
                    break;
                case "empty":
                    if (deque.isEmpty()) sb.append(1).append('\n');
                    else sb.append(0).append('\n');
                    break;
                case "front":
                    if (deque.peek() == null) sb.append(-1).append('\n');
                    else sb.append(deque.peek()).append('\n');
                    break;
                case "back":
                    if (deque.peekLast() == null) sb.append(-1).append('\n');
                    else sb.append(deque.peekLast()).append('\n');
                    break;
            }
        }

        System.out.println(sb);
    }

}