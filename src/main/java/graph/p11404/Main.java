package graph.p11404;

import java.io.IOException;

public class Main {

    static int N, M;
    static int[][] distance;

    public static void main(String[] args) throws IOException {
        N = readInt();
        M = readInt();

        distance = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) distance[i][j] = 0;
                else distance[i][j] = 1000000000;
            }
        }

        for (int i = 0; i < M; i++) {
            int s = readInt();
            int e = readInt();
            int v = readInt();

            if (distance[s][e] > v) distance[s][e] = v;
        }

        for (int k = 1; k <= N; k++) {
            for (int s = 1; s <= N; s++) {
                for (int e = 1; e <= N; e++) {
                    if (distance[s][e] > distance[s][k] + distance[k][e])
                        distance[s][e] = distance[s][k] + distance[k][e];
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (distance[i][j] == 1000000000) System.out.print("0 ");
                else System.out.print(distance[i][j] + " ");
            }
            System.out.println();
        }

    }

    static int readInt() throws IOException {
        int n = 0;
        boolean isNegative = false;
        while (true) {
            int input = System.in.read();
            if (input <= 32) {
                return isNegative ? n * -1 : n;
            } else if (input == '-')
                isNegative = true;
            else
                n = (n << 3) + (n << 1) + (input & 15);
        }
    }

}
