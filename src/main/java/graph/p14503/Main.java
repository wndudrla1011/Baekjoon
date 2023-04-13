package graph.p14503;

import java.io.IOException;

public class Main {

    static int Y, X, d;
    static int[][] A;
    //북(d=0), 동(d=1), 남(d=2), 서(d=3)
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int count; //청소 완료한 칸 수

    public static void main(String[] args) throws IOException {
        Y = readInt(); //행 개수
        X = readInt(); //열 개수
        A = new int[Y][X];
        int r = readInt(); //시작 행 위치
        int c = readInt(); //시작 열 위치
        d = readInt(); //현재 바라보는 방향
        count = 1;

        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                A[i][j] = readInt();
            }
        }

        DFS(r, c, d);

        System.out.println(count);
    }

    static void DFS(int r, int c, int dir) { //dir : 청소기가 바라보는 방향
        A[r][c] = -1; //현재 위치 청소
//        System.out.println(r + "," + c + "," + dir);

        //현재 위치에서 현재 방향을 기준으로 왼쪽 방향부터 탐색
        for (int i = 0; i < 4; i++) {
            dir = (dir + 3) % 4; //왼쪽 방향으로 변환 (북 -> 서 -> 남 -> 동)
            int ny = r + dy[dir];
            int nx = c + dx[dir];
            if (ny >= 0 && ny < Y && nx >= 0 && nx < X && A[ny][nx] == 0) { //청소되지 않은 빈 칸이 있다면
                count++; //청소 칸 추가
                DFS(ny, nx, dir); //그 칸으로 전진

                /*
                * 여기서 return 을 안하면 복귀하는 도중 뒤로가서 다른 곳을 청소할 수가 있음
                * 여기로 왔다는 것은 상하좌우 이동 x && 후진 x 상황까지 온 것
                * 동작 : 작동 멈춰야 함
                * */
//                System.out.println("후진 불가! >> " + ny + "," + nx + "," + dir);
                return;
            }
        }

        /*
        * 청소되지 않은 빈 칸이 없다면
        * 청소가 되어 있더라도 후진 가능
        * 바라보는 방향을 유지한 채로 한 칸 후진
        * */
        int back = (dir + 2) % 4;
        int by = r + dy[back];
        int bx = c + dx[back];

        if (by >= 0 && by < Y && bx >= 0 && bx < X && A[by][bx] != 1) {
//            System.out.println("후진!");
            DFS(by, bx, dir);
        }
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
