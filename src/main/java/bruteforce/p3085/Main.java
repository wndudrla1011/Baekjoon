package bruteforce.p3085;

import java.io.*;

public class Main {

    static int N;
    static char[][] candy;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        candy = new char[N][N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                candy[i][j] = input.charAt(j);
            }
        }

        //가로 방향 교환
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                //가로로 인접한 두 사탕 교환
                swap_width(i, j);

                //가로, 세로 최대 사탕 개수 체크
                checkPoint();

                //이전에 교환했던 사탕 복구
                swap_width(i, j);
            }
        }

        //세로 방향 교환
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                //세로로 인접한 두 사탕 교환
                swap_height(j, i);

                //가로, 세로 최대 사탕 개수 체크
                checkPoint();

                //이전에 교환했던 사탕 복구
                swap_height(j, i);
            }
        }

        System.out.println(max);
    }

    static void swap_width(int i, int j) {
        char tmp = candy[i][j];
        candy[i][j] = candy[i][j + 1];
        candy[i][j + 1] = tmp;
    }

    static void swap_height(int i, int j) {
        char tmp = candy[i][j];
        candy[i][j] = candy[i + 1][j];
        candy[i + 1][j] = tmp;
    }

    /*
    * 해당 좌표에서 가로, 세로 방향으로 최대 사탕 개수 카운팅
    * */
    static void checkPoint() {
        //가로 체크
        for (int i = 0; i < N; i++) {
            int count = 1;
            for (int j = 0; j < N - 1; j++) {
                if (candy[i][j] == candy[i][j + 1]) //사탕 먹기
                    count++;
                else //이전과 다른 사탕이라면 1부터 다시 카운팅
                    count = 1;

                max = Math.max(max, count); //사탕 개수 저장
            }
        }

        //세로 체크
        for (int i = 0; i < N; i++) {
            int count = 1;
            for (int j = 0; j < N - 1; j++) {
                if (candy[j][i] == candy[j + 1][i]) //사탕 먹기
                    count++;
                else //이전과 다른 사탕이라면 1부터 다시 카운팅
                    count = 1;

                max = Math.max(max, count); //사탕 개수 저장
            }
        }
    }
}
