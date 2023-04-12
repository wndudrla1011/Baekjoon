package graph.p13913;

import java.io.IOException;
import java.util.*;

public class Main {

    static int start, end;
    static int[] time = new int[100001]; //각 인덱스는 현재 시간을 저장
    static int[] parent = new int[100001]; //각 인덱스는 부모 노드의 값 저장

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        start = readInt();
        end = readInt();

        BFS();

        //순서대로 구하기 위해 Stack 에 담았다가 pop
        Stack<Integer> stack = new Stack<>();
        stack.push(end);
        int index = end;

        while (index != start) {
            stack.push(parent[index]); //부모 값 저장
            index = parent[index]; //다음 부모로 이동
        }

        //최종 출력
        sb.append(time[end] - 1).append('\n');
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(sb);
    }

    static void BFS() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        time[start] = 1;

        while (!q.isEmpty()) {
            int now = q.poll();

            if (now == end) return;

            for (int i = 0; i < 3; i++) {
                int next; //이동 가능한 값

                if (i == 0) next = now + 1;
                else if (i == 1) next = now - 1;
                else next = now * 2;

                if (next < 0 || next > 100000) continue;

                if (time[next] == 0) {
                    q.offer(next);
                    time[next] = time[now] + 1; //시간 1초 증가
                    parent[next] = now; //now : 부모, next : 자식
                }
            }
        }
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c  = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
