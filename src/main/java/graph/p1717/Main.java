package graph.p1717;

import java.io.IOException;

public class Main {

    static int N, M;
    static int[] A;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        N = readInt();
        M = readInt();
        A = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            A[i] = i;
        }

        for (int i = 1; i <= M; i++) {
            int op = readInt();
            int a = readInt();
            int b = readInt();
            if (op == 0) {
                union(a, b);
            } else {
                //대표 노드가(소속된 집합이) 같으면 YES, 다르면 NO
                if (find(a) == find(b)) {
                    sb.append("YES").append('\n');
                } else {
                    sb.append("NO").append('\n');
                }
            }
        }

        System.out.println(sb);
    }

    //대표 노드끼리 연결
    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) A[b] = a; //b를 a의 집합에 넣기 (b의 대표 노드 == a)
    }

    //대표노드 찾기
    private static int find(int a) {
        if (a == A[a]) return a; //대표노드
        else return A[a] = find(A[a]); //탐색한 모든 노드의 대표 노드 수정
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
