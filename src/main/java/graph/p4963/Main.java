package graph.p4963;

import java.io.*;
import java.util.*;

public class Main {

    static int[][] A;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};
    static int w, h, cnt; //cnt : 섬의 개수

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        while (true) {
            w = readInt();
            h = readInt();
            if (w == 0 && h == 0) break;
            A = new int[h][w];
            visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    A[i][j] = readInt();
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (!visited[i][j] && A[i][j] == 1) { //방문 전이고 대지라면
                        BFS(i, j);
                        cnt++;
                    }
                }
            }

            sb.append(cnt).append('\n');
            cnt = 0;
        }

        System.out.println(sb);
    }

    static void BFS(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        visited[i][j] = true;

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int y = node[0];
            int x = node[1];

            for (int t = 0; t < 8; t++) { //상하좌우 + 대각선 탐색
                int ny = y + dy[t];
                int nx = x + dx[t];
                if (ny >= 0 && ny < h && nx >= 0 && nx < w) {
                    if (!visited[ny][nx] && A[ny][nx] == 1) { //방문 전이고 대지라면
                        visited[ny][nx] = true;
                        q.offer(new int[]{ny, nx});
                    }
                }
            }
        }
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
