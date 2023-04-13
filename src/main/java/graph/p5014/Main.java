package graph.p5014;

import java.io.IOException;
import java.util.*;

public class Main {

    static int F, S, G, U, D;
    static int[] distance = new int[1000001]; //첫 방문일 때 거리(최소 거리)

    public static void main(String[] args) throws IOException {
        F = readInt(); //꼭대기 층
        S = readInt(); //현재 위치
        G = readInt(); //목적지
        U = readInt(); //현재 +U
        D = readInt(); //현재 -D

        BFS();
    }

    static void BFS() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(S);
        distance[S] = 1;

        while (!q.isEmpty()) {
            int now = q.poll(); //현재 층

            if (now == G) { //목적지 도착
                System.out.println(distance[now] - 1);
                return;
            }

            int next; //다음 층
            for (int i = 0; i < 2; i++) {
                if (i == 0) next = now + U;
                else next = now - D;

                if (next < 1 || next > F) continue; //유효한 층인가

                if (distance[next] == 0) { //첫 방문
                    distance[next] = distance[now] + 1; //버튼 클릭 +1회
                    q.offer(next);
                }
            }
        }

        System.out.println("use the stairs"); //목적지에 도달할 수 없는 경우
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
