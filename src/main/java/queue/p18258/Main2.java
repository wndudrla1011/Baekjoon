package queue.p18258;

import java.io.*;
import java.util.StringTokenizer;

public class Main2 {

    static int[] queue;
    static int head = 0, tail = 0;
    static void push(int X) { queue[tail++] = X; }
    static int pop() { return head == tail ? -1 : queue[head++]; }
    static int size() { return tail - head; }
    static int empty() { return head == tail ? 1 : 0; }
    static int front() { return head == tail ? -1 : queue[head]; }
    static int back() { return head == tail ? -1 : queue[tail - 1];}

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        queue = new int[2000000];

        StringTokenizer command;

        while (N-- > 0) {
            command = new StringTokenizer(br.readLine(), " ");
            switch (command.nextToken()) {
                case "push":
                    push(Integer.parseInt(command.nextToken()));
                    break;
                case "pop":
                    sb.append(pop()).append('\n');
                    break;
                case "size":
                    sb.append(size()).append('\n');
                    break;
                case "empty":
                    sb.append(empty()).append('\n');
                    break;
                case "front":
                    sb.append(front()).append('\n');
                    break;
                case "back":
                    sb.append(back()).append('\n');
                    break;
            }
        }

        System.out.println(sb);
    }

}
