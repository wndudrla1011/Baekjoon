package graph.p13023;

import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static int N, M;
    static boolean arrive; //도착 확인 변수

    public static void main(String[] args) throws IOException {
        N = readInt();
        M = readInt();

        A = new ArrayList[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            A[i] = new ArrayList<>();
        }

        while (M-- > 0) {
            int s = readInt();
            int e = readInt();
            A[s].add(e);
            A[e].add(s);
        }

        for (int i = 0; i < N; i++) {
            DFS(i, 1);
            if (arrive) break;
        }

        System.out.println(arrive ? 1 : 0);
    }

    static void DFS(int now, int depth) {
        if (depth == 5 || arrive) { //깊이 5까지 도달한 적이 있다면 종료
            arrive = true;
            return;
        }
        visited[now] = true;
        for (int i : A[now]) {
            if (!visited[i])
                DFS(i, depth + 1);
        }
        /*
        * 해당 재귀 종료 -> 방문 체크 해제
        * 1. 더 이상 진출할 위치가 없어 되돌아오는 경우
        * 2. depth 5까지 다녀온 경우
        * 3. 뒤로가기 라고 생각하기
        * */
        visited[now] = false;
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
