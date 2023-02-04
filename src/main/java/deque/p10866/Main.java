package deque.p10866;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static final int SIZE = 20000;
    static int[] deque = new int[SIZE];
    static int front = 10000, rear = 10000;
    static void push_front(int X) { deque[(--front + SIZE) % SIZE] = X; }
    static void push_back(int X) { deque[(rear++ + SIZE) % SIZE] = X; }
    static int pop_front() { return front == rear ? -1 : deque[(front++ + SIZE) % SIZE]; }
    static int pop_back() { return front == rear ? -1 : deque[(--rear + SIZE) % SIZE]; }
    static int size() { return rear - front; }
    static int empty() { return front == rear ? 1 : 0; }
    static int front() { return front == rear ? -1 : deque[(front + SIZE) % SIZE]; }
    static int back() { return front == rear ? -1 : deque[(rear - 1 + SIZE) % SIZE]; }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer command;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            command = new StringTokenizer(br.readLine());
            switch (command.nextToken()) {
                case "push_front":
                    push_front(Integer.parseInt(command.nextToken()));
                    break;
                case "push_back":
                    push_back(Integer.parseInt(command.nextToken()));
                    break;
                case "pop_front":
                    sb.append(pop_front()).append('\n');
                    break;
                case "pop_back":
                    sb.append(pop_back()).append('\n');
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
