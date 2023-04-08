package graph.p7562;

import java.io.IOException;
import java.util.*;

public class Main {

    //나이트가 이동 가능한 (y, x)좌표
    static int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[][] A;
    static boolean[][] visited;
    static int di, dj, I;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int T = readInt();
        while (T-- > 0) {
            I = readInt(); //체스판 크기(IxI)
            A = new int[I][I];
            visited = new boolean[I][I];
            int si = readInt(); //출발지 y좌표
            int sj = readInt(); //출발지 x좌표
            di = readInt(); //목적지 y좌표
            dj = readInt(); //목적지 x좌표
            if (si == di && sj == dj) { //출발지와 목적지 좌표가 같은 경우
                sb.append(0).append('\n');
                continue;
            }
            sb.append(BFS(si, sj)).append('\n');
        }

        System.out.println(sb);
    }

    static int BFS(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        visited[i][j] = true;

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int y = node[0];
            int x = node[1];
            for (int t = 0; t < 8; t++) { //나이트가 이동 가능한 위치 탐색
                int ny = y + dy[t];
                int nx = x + dx[t];
                if (ny >= 0 && ny < I && nx >= 0 && nx < I) { //위치가 유효하다면
                    if (!visited[ny][nx]) {
                        visited[ny][nx] = true;
                        A[ny][nx] = A[y][x] + 1; //이동 횟수 누적
                        if (ny == di && nx == dj) { //탐색한 위치 == 목적지(종료)
                            return A[ny][nx];
                        }
                        q.offer(new int[]{ny, nx});
                    }
                }
            }
        }

        return -1;
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
