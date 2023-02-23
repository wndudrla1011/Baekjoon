package accumulated_sum.p16507;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int R = readInt();
        int C = readInt();
        int Q = readInt();

        int[][] picture = new int[R + 1][C + 1];
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                picture[i][j] = readInt();
            }
        }

        int[][] S = new int[R + 1][C + 1];
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                S[i][j] = S[i - 1][j] + S[i][j - 1] - S[i - 1][j - 1] + picture[i][j]; //2차원 배열 누적 합 - 원소
            }
        }

        while (Q-- > 0) {
            int r1 = readInt();
            int c1 = readInt();
            int r2 = readInt();
            int c2 = readInt();

            int area = (c2 - c1 + 1) * (r2 - r1 + 1);
            //2차원 배열 누적 합 배열의 구간 합 / 직사각형 넓이
            sb.append((S[r2][c2] - S[r2][c1 - 1] - S[r1 - 1][c2] + S[r1 - 1][c1 - 1]) / area).append('\n');
        }

        System.out.println(sb);
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
