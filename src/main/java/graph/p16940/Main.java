package graph.p16940;

import java.io.IOException;
import java.util.*;

public class Main {

    static ArrayList<Integer>[] A;
    static Queue<Integer> q;
    static boolean[] visited;
    static int[] ans; //정답 순서
    static int N, idx;

    public static void main(String[] args) throws IOException {
        N = readInt(); //정점의 수
        A = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        ans = new int[N + 1];
        q = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        //인접 리스트 생성
        for (int i = 0; i < N - 1; i++) {
            int s = readInt();
            int e = readInt();
            A[s].add(e);
            A[e].add(s);
        }

        //정답 생성
        for (int i = 1; i <= N; i++) {
            ans[i] = readInt();
        }

        //시작이 1이 아니면 안됨
        if (ans[1] != 1) {
            System.out.println("0");
            return;
        }

        checkBFS(1);
    }

    static void checkBFS(int v) {
        q.offer(v);
        visited[v] = true;
        idx = 2;

        while (!q.isEmpty()) {
            int x = q.poll();
            //현재 노드의 자식들 방문 처리
            int count = 0;
            for (int i : A[x]) {
                if (!visited[i]) {
                    visited[i] = true;
                    count++;
                }
            }

            for (int i = idx; i < idx + count; i++) {
                //정답이 현재 노드의 자식이 아니라면
                if (!visited[ans[i]]) {
                    System.out.println("0");
                    return;
                }
                //정답이 현재 노드의 자식이라면 큐에 순서대로 삽입
                else {
                    q.offer(ans[i]);
                }
            }
            idx += count;
        }

        System.out.println(1);
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
