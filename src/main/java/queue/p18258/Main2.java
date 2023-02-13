package queue.p18258;

import java.io.*;
import java.util.StringTokenizer;

public class Main2 {

    static int front = 0, rear = 0;
    static int[] queue;
    static void push(int X) {queue[rear++] = X;}
    static int pop() {return rear - front == 0 ? -1 : queue[front++];}
    static int size() {return rear - front;}
    static int empty() {return rear - front == 0 ? 1 : 0;}
    static int front() {return rear - front == 0 ? -1 : queue[front];}
    static int back() {return rear - front == 0 ? -1 : queue[rear - 1];}

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        queue = new int[N];

        StringTokenizer command;
        while (N-- > 0) {
            command = new StringTokenizer(br.readLine(), " ");
            switch (command.nextToken()) {
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
                default:
                    push(Integer.parseInt(command.nextToken()));
                    break;
            }
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main2().solution();
    }

}
