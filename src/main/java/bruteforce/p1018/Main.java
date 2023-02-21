package bruteforce.p1018;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static boolean[][] chessBoard; //W : true, B : false
    static int min = 64;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        chessBoard = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            for (int j = 0; j < M; j++) {
                if (str.charAt(j) == 'W') chessBoard[i][j] = true;
                else chessBoard[i][j] = false;
            }
        }

        int N_row = N - 7;
        int M_row = M - 7;

        for (int i = 0; i < N_row; i++) {
            for (int j = 0; j < M_row; j++) {
                find(i, j);
            }
        }

        System.out.println(min);
    }

    private static void find(int x, int y) {
        int end_x = x + 8;
        int end_y = y + 8;
        int count = 0;

        boolean TF = chessBoard[x][y]; //첫 번째 칸의 색

        for (int i = x; i < end_x; i++) {
            for (int j = y; j < end_y; j++) {
                //올바른 색이 아닐 경우 count 1 증가
                if (chessBoard[i][j] != TF) count++;

                /*
                 * 다음 칸은 색이 바뀌므로
                 * true 라면 false 로, false 라면 true 로
                 * 값 변경
                 * */
                TF = !TF;
            }
            TF = !TF;
        }

        /*
        * 첫 번째 칸을 기준으로 할 때의 색칠 할 개수(count)와
        * 첫 번째 칸의 색의 반대되는 색을 기준으로 할 때의
        * 색칠 할 개수(64 - count) 중 최솟값을 count에 저장
        * */
        count = Math.min(count, 64 - count);

        /*
        * 이전까지의 경우 중 최솟값보다 현재 count 값이
        * 더 작을 경우 최솟값을 갱신
        * */
        min = Math.min(min, count);
    }

}