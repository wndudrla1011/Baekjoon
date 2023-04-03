package graph.p16956;

import java.io.*;
import java.util.*;

public class Main {

    static int R, C;
    static char[][] A;
    static Queue<int[]> q = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean flag = true;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        A = new char[R][C];

        for (int i = 0; i < R; i++) {
            String row = br.readLine();
            for (int j = 0; j < C; j++) {
                A[i][j] = row.charAt(j);
                if (A[i][j] == 'W')
                    q.add(new int[]{i, j}); //늑대 위치 저장
            }
        }

        BFS();

        if (flag) {
            sb.append(1).append('\n');
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    sb.append(A[i][j]);
                }
                sb.append('\n');
            }
        } else {
            sb.append(0).append('\n');
        }

        System.out.println(sb);
    }

    private static void BFS() {
        while (!q.isEmpty()) {
            int[] t = q.poll();
            int x = t[0]; //x좌표
            int y = t[1]; //y좌표
            for (int i = 0; i < 4; i++) { //상하좌우 탐색
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < R && ny >= 0 && ny < C) { //좌표 유효성 검사
                    if (A[nx][ny] == '.') //빈칸일 경우 울타리 설치
                        A[nx][ny] = 'D';
                    else if (A[nx][ny] == 'S') { //양의 위치를 찾으면 종료
                        flag = false;
                        return;
                    }
                }
            }
        }
    }

}
