package string.p2115;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int cnt = 0;

        String[][] map = new String[M + 1][N + 1];
        for (int r = 1; r <= M; r++) {
            String[] column = br.readLine().split("");
            for (int c = 1; c <= N; c++) {
                map[r][c] = column[c - 1];
            }
        }

        for (int r = 2; r < M; r++) {
            for (int c = 2; c < N; c++) {
                if (map[r][c].equals(".")) {
                    if (map[r - 1][c].equals(".")) { //위 빈칸
                        if (map[r - 1][c - 1].contains("X") && !map[r - 1][c - 1].contains("R") &&
                                map[r][c - 1].contains("X") && !map[r][c - 1].contains("R")) { //왼쪽 벽 전시
                            cnt++;
                            map[r - 1][c - 1] += "R";
                            map[r][c - 1] += "R";
                        }
                        if (map[r - 1][c + 1].contains("X") && !map[r - 1][c + 1].contains("L") &&
                                map[r][c + 1].contains("X") && !map[r][c + 1].contains("L")) { //오른쪽 벽 전시
                            cnt++;
                            map[r - 1][c + 1] += "L";
                            map[r][c + 1] += "L";
                        }
                    }
                    if (map[r + 1][c].equals(".")) { //아래 빈칸
                        if (map[r][c - 1].contains("X") && !map[r][c - 1].contains("R") &&
                                map[r + 1][c - 1].contains("X") && !map[r + 1][c - 1].contains("R")) { //왼쪽 벽 전시
                            cnt++;
                            map[r][c - 1] += "R";
                            map[r + 1][c - 1] += "R";
                        }
                        if (map[r][c + 1].contains("X") && !map[r][c + 1].contains("L") &&
                                map[r + 1][c + 1].contains("X") && !map[r + 1][c + 1].contains("L")) { //오른쪽 벽 전시
                            cnt++;
                            map[r][c + 1] += "L";
                            map[r + 1][c + 1] += "L";
                        }
                    }
                    if (map[r][c - 1].equals(".")) { //좌측 빈칸
                        if (map[r - 1][c - 1].contains("X") && !map[r - 1][c - 1].contains("B") &&
                                map[r - 1][c].contains("X") && !map[r - 1][c].contains("B")) { //윗쪽 벽 전시
                            cnt++;
                            map[r - 1][c - 1] += "B";
                            map[r - 1][c] += "B";
                        }
                        if (map[r + 1][c - 1].contains("X") && !map[r + 1][c - 1].contains("T") &&
                                map[r + 1][c].contains("X") && !map[r + 1][c].contains("T")) { //아랫쪽 벽 전시
                            cnt++;
                            map[r + 1][c - 1] += "T";
                            map[r + 1][c] += "T";
                        }
                    }
                    if (map[r][c + 1].equals(".")) { //우측 빈칸
                        if (map[r - 1][c].contains("X") && !map[r - 1][c].contains("B") &&
                                map[r - 1][c + 1].contains("X") && !map[r - 1][c + 1].contains("B")) { //윗쪽 벽 전시
                            cnt++;
                            map[r - 1][c] += "B";
                            map[r - 1][c + 1] += "B";
                        }
                        if (map[r + 1][c].contains("X") && !map[r + 1][c].contains("T") &&
                                map[r + 1][c + 1].contains("X") && !map[r + 1][c + 1].contains("T")) { //아랫쪽 벽 전시
                            cnt++;
                            map[r + 1][c] += "T";
                            map[r + 1][c + 1] += "T";
                        }
                    }
                }
            }
        }

        System.out.println(cnt);
    }

}
