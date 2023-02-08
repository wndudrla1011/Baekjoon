package priorityQ.p1655;

import java.io.IOException;
import java.util.PriorityQueue;

public class Main2 {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> small = new PriorityQueue<>();
        PriorityQueue<Integer> large = new PriorityQueue<>();

        int N = readInt();
        int median = readInt();
        sb.append(median).append('\n');

        for (int i = 1; i < N; i++) {
            int x = readInt();

            if (i % 2 == 1) {
                if (x >= median) large.add(-x);
                else {
                    large.add(median); //median보다 작은 수가 왔으므로 median은 large로
                    small.add(-x); //가장 큰 수를 얻기 위해 음수 취함
                    median = -small.poll(); //작은 집단에서 가장 큰 수
                }
            }
            else {
                if (x <= median) small.add(x);
                else {
                    small.add(-median); //median보다 큰 수가 왔으므로 median은 small로
                    large.add(x); //현재 수를 large에 넣은 후
                    median = large.poll(); //큰 집단에서 가장 작은 수
                }
            }

            sb.append(median).append('\n');
        }

        System.out.println(sb);
    }

    static int readInt() throws IOException {
        int n = 0;
        boolean isNegative = false;
        while (true) {
            int input = System.in.read();
            if (input <= 32) {
                return isNegative ? n * -1 : n;
            } else if (input == '-')
                isNegative = true;
            else
                n = (n << 3) + (n << 1) + (input & 15);
        }
     }

}
