package queue.p10845;

import java.io.*;

public class Main {

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

        int N = Integer.parseInt(br.readLine());
        queue = new int[N];

        for (int i = 0; i < N; i++) {
            String command = br.readLine();
            switch (command) {
                case "pop":
                    System.out.println(pop());
                    break;
                case "size":
                    System.out.println(size());
                    break;
                case "empty":
                    System.out.println(empty());
                    break;
                case "front":
                    System.out.println(front());
                    break;
                case "back":
                    System.out.println(back());
                    break;
                default:
                    String[] c = command.split(" ");
                    push(Integer.parseInt(c[1]));
                    break;
            }
        }
    }

}
