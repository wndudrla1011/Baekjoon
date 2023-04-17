package graph.p16947;

import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static boolean isCycle;;
    static int[] distance;
    static int N;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        N = readInt();
        A = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        distance = new int[N + 1];
        Arrays.fill(distance, -1);

        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            int s = readInt();
            int e = readInt();
            A[s].add(e);
            A[e].add(s);
        }

        //경로에서 순환선 찾기
        DFS(0, 1);

        //각 역과 순환선 사이 거리 구하기
        BFS();

        for (int i = 1; i <= N; i++) {
            sb.append(distance[i]).append(" ");
        }

        System.out.println(sb);
    }

    static void BFS() {
        int cnt = 1;
        while (!q.isEmpty()) {
            /*
            * 최초 큐 사이즈 -> 거리 1인 장소들 확인
            * 큐 사이즈만큼 작업한 후에는 거리 1 증가
            * */
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int circular_line = q.poll();
                //연결된 구간을 다음 탐색지에 추가
                for (int j : A[circular_line]) {
                    //거리가 이미 구해진 역은 제외
                    if (distance[j] != -1) continue;
                    distance[j] = cnt;
                    q.offer(j);
                }
            }
            cnt++; //순환선과의 거리
        }
    }

    static void DFS(int prev, int cur) {
        visited[cur] = true;
        for (int i : A[cur]) {
            //직전 방문지가 아니고 이미 방문한 곳에 도착 -> 사이클
            if (visited[i] && i != prev) {
                isCycle = true; //순환역 확인
                distance[i] = 0; //순환역이므로 거리 0
                q.offer(i);
                break;
            } else if (!visited[i]) {
                DFS(cur, i); //다음 역 탐색
                //인접한 역 중 순환역을 찾지 못했거나 순환역을 찾은 경우
                if (isCycle) { //순환선에 속한 역
                    if (distance[i] == 0) { //이미 사이클에 속한 곳을 만남 -> 사이클 종료
                        isCycle = false; //순환선 작업이 끝난 후에는 이 작업을 다시 수행하지 않도록
                    } else { //순환역을 도는 중
                        distance[i] = 0;
                        q.offer(i);
                    }
                    return; //순환역을 찾은 후 저장 -> 작업 종료
                }
            }
        }
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
