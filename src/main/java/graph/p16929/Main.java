package graph.p16929;

import java.io.*;
import java.util.*;

public class Main {

    static boolean[][] visited;
    static char[][] A;
    static int Y, X;
    static int initY, initX;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        A = new char[Y][X];

        String input;
        for (int i = 0; i < Y; i++) {
            input = br.readLine();
            for (int j = 0; j < X; j++) {
                A[i][j] = input.charAt(j);
            }
        }

        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                visited = new boolean[Y][X];
                initY = i;
                initX = j;
                if (DFS(i, j, 1)) {
                    System.out.println("Yes");
                    return;
                }
            }
        }

        System.out.println("No");
    }

    static boolean DFS(int y, int x, int cnt) {
        visited[y][x] = true;
        for (int t = 0; t < 4; t++) {
            int ny = y + dy[t];
            int nx = x + dx[t];
            if (ny >= 0 && ny < Y && nx >= 0 && nx < X && A[ny][nx] == A[y][x]) {
                if (!visited[ny][nx]) {
                    if (DFS(ny, nx, cnt + 1)) return true;
                } else {
                    if (cnt >= 4 && initY == ny && initX == nx) return true;
                }
            }
        }
        return false;
    }

}
