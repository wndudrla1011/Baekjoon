package math.p11050;

import java.io.IOException;
import java.util.*;

public class Main {

    static int[] visited; // 방문 여부
    static int N, K, ans;

    public static void main(String[] args) throws IOException {
        N = readInt(); // 총 개수
        K = readInt(); // 뽑을 개수
        visited = new int[N + 1];

        DFS(1, 0);
        System.out.println(ans);
    }

    static void DFS(int S, int cnt) {
        if (cnt == K) {
            ans++;
            return;
        }
        for (int i = S; i <= N; i++) {
            if (visited[i] == 0) {
                visited[i] = 1; // 방문
                DFS(i + 1, cnt + 1);
                visited[i] = 0; // 방문 해제
            }
        }
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
