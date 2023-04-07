package graph.p2667;

import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] A;
    static boolean[][] visited;
    static List<Integer> total = new ArrayList<>(); //모든 단지 수 저장
    static int cnt, N; //cnt : 각 단지 수 저장

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
                if (A[i][j] == 1 && !visited[i][j]) { //방문 전이고 길이 있다면
                    BFS(i, j);
                    total.add(cnt);
                    cnt = 0;
                }
            }
        }

        sb.append(total.size()).append('\n');
        Collections.sort(total);

        for (int count : total) {
            sb.append(count).append('\n');
        }

        System.out.println(sb);
    }

    static void BFS(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        visited[i][j] = true;
        cnt++;

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int x = node[0];
            int y = node[1];
            for (int t = 0; t < 4; t++) {
                int nx = x + dx[t];
                int ny = y + dy[t];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N) { //좌표가 유효할 경우
                    if (!visited[nx][ny] && A[nx][ny] == 1) { //방문 전이고 길이 있다면
                        visited[nx][ny] = true;
                        cnt++;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }

}
