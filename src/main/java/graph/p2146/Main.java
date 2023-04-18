package graph.p2146;

import java.io.IOException;
import java.util.*;

public class Main {

    static int[][] A;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int landNum = 2; //섬 번호 이름
    static int N;
    static int ans = Integer.MAX_VALUE; //최소 거리

    public static void main(String[] args) throws IOException {
        N = readInt();
        A = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                A[i][j] = readInt();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (A[i][j] == 1) { //아직 번호가 부여되지 않은 섬
                    makeLand(i, j);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (A[i][j] >= 2) { //번호가 부여된 섬
                    visited = new boolean[N][N]; //방문 배열 초기화
                    BFS(i, j);
                }
            }
        }

        System.out.println(ans);
    }

    //섬 별로 번호이름 붙여주기
    static void makeLand(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        visited[i][j] = true;
        A[i][j] = landNum; //현재 부여해야 할 번호

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int y = node[0];
            int x = node[1];
            for (int t = 0; t < 4; t++) {
                int ny = y + dy[t];
                int nx = x + dx[t];
                if (ny >= 0 && ny < N && nx >= 0 && nx < N && !visited[ny][nx]) {
                    if (A[ny][nx] == 1) { //번호가 부여되지 않은 섬
                        visited[ny][nx] = true;
                        A[ny][nx] = landNum; //번호 부여
                        q.offer(new int[]{ny, nx}); //섬 탐색
                    }
                }
            }
        }

        /*
        * 한 블럭과 이어진 모든 블럭들의 번호 부여가 끝난 상황
        * 다른 섬에 번호를 부여하기 위해 번호 증가
        * */
        landNum++;
    }

    static void BFS(int i, int j) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(i, j, 0));
        int curLandNum = A[i][j]; //현재 섬 번호
        visited[i][j] = true;

        while (!q.isEmpty()) {
            Point point = q.poll();
            for (int t = 0; t < 4; t++) {
                int ny = point.r + dy[t];
                int nx = point.c + dx[t];
                if (ny >= 0 && ny < N && nx >= 0 && nx < N && !visited[ny][nx]) { //방문 전인 곳
                    if (A[ny][nx] != curLandNum) { //바다 혹은 다른 섬
                        visited[ny][nx] = true;
                        if (A[ny][nx] == 0) { //바다
                            q.offer(new Point(ny, nx, point.cnt + 1));
                        } else { //다른 섬
                            ans = Math.min(ans, point.cnt);
                            return;
                        }
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

class Point {
    int r;
    int c;
    int cnt; //섬과 섬 사이 블럭 개수(즉 바다 개수)

    public Point(int r, int c, int cnt) {
        this.r = r;
        this.c = c;
        this.cnt = cnt;
    }
}