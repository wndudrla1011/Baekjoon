package graph.p1261;

import java.io.*;
import java.util.*;

public class Main {

    static int X, Y; //X : 열의 개수, Y : 행의 개수
    static int[][] A;
    static int[][] distance = new int[101][101]; //각 좌표일 때의 거리(벽 개수) 저장
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        A = new int[Y + 1][X + 1];

        for (int i = 1; i <= Y; i++) {
            String row = br.readLine();
            for (int j = 1; j <= X; j++) {
                A[i][j] = row.charAt(j - 1) - '0';
            }
        }

        BFS();
    }

    static void BFS() {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{1, 1});
        distance[1][1] = 1;

        while (!deque.isEmpty()) {
            int[] coordinate = deque.poll();
            int y = coordinate[0];
            int x = coordinate[1];

            if (y == Y && x == X) {
                System.out.println(distance[y][x] - 1);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny >= 1 && ny <= Y && nx >= 1 && nx <= X) {
                    if (distance[ny][nx] == 0) { //방문 전
                        if (A[ny][nx] == 0) { //가중치 0
                            distance[ny][nx] = distance[y][x];
                            deque.offerFirst(new int[]{ny, nx});
                        } else { //가중치 1
                            distance[ny][nx] = distance[y][x] + 1;
                            deque.offer(new int[]{ny, nx});
                        }
                    }
                }
            }
        }
    }

}
