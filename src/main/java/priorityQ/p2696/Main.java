package priorityQ.p2696;

import java.io.IOException;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> small;
        PriorityQueue<Integer> large;
        int medianCnt;

        int T = readInt();

        while (T-- > 0) {
            small = new PriorityQueue<>();
            large = new PriorityQueue<>();
            int M = readInt();
            int median = readInt();
            sb.append(median).append(" ");
            medianCnt = 1;

            for (int i = 1; i < M; i++) {
                int x = readInt();
                if (i % 2 == 1) { //small 크기 == large 크기
                    if (x >= median) large.offer(x);
                    else {
                        large.add(median);
                        small.add(-x);
                        median = -small.poll();
                    }
                }
                else { //small 크기 != large 크기
                    if (x <= median) small.offer(-x);
                    else {
                        small.add(-median);
                        large.add(x);
                        median = large.poll();
                    }
                    sb.append(median).append(" "); //홀수 번째마다 중앙값 출력
                    medianCnt++; //홀수 번째마다 중앙값 카운팅
                    if (medianCnt % 10 == 0) sb.append('\n'); //숫자 10개 찍을 때마다 개행
                }
            }
            sb.insert(0, medianCnt + "\n");
            System.out.println(sb);
            sb.setLength(0);
        }

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
