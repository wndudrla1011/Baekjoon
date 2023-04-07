package graph.p2667;

import java.io.*;
import java.util.*;

public class Main2 {

    static PriorityQueue<Integer> houses = new PriorityQueue<>(); //모든 단지별 개수
    static int[][] A;
    static boolean[][] visited;
    static int N;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N][N];
        visited = new boolean[N][N];

        //Map -> A 저장
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                A[i][j] = s.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) { //방문 전
                    int ret = DFS(i, j);
                    if (ret != 0) houses.add(ret);
                }
            }
        }

        sb.append(houses.size()).append('\n');

        while (!houses.isEmpty())
            sb.append(houses.poll()).append('\n');

        System.out.println(sb);
    }

    static int DFS(int y, int x) {
        if (y < 0 || y >= N || x < 0 || x >= N) return 0; //좌표 유효성
        if (visited[y][x]) return 0; //방문했다면 리턴
        visited[y][x] = true; //방문 체크
        if (A[y][x] == 0) return 0; //이동 불가능한 경우

        /*
        * 좌우상하 재귀
        * 현재 좌표 포함해야 하므로 1 더함
        * */
        return 1 + DFS(y - 1, x) + DFS(y + 1, x) + DFS(y, x - 1) + DFS(y, x + 1);
    }

}
