package queue.p1966;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            LinkedList<int[]> queue = new LinkedList<>();
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++)
                queue.offer(new int[]{i, Integer.parseInt(st.nextToken())}); //{초기 위치, 중요도}

            int cnt = 0; //출력 횟수
            while (!queue.isEmpty()) {
                int[] front = queue.poll(); //가장 첫 원소
                boolean isMax = true; //front 원소가 가장 큰 원소인지 판단

                //큐에 남아있는 원소들과 중요도 비교 -> 큰 값 등장하면 바로 종료
                for (int i = 0; i < queue.size(); i++) {
                    //처음 뽑은 원소보다 큐의 i번째 원소의 중요도가 클 경우
                    if (front[1] < queue.get(i)[1]) {
                        //뽑은 원소 및 i 이전 원소들을 뒤로 보냄
                        queue.offer(front);
                        for (int j = 0; j < i; j++) queue.offer(queue.poll());

                        //front 원소가 가장 큰 원소가 아니었으므로 false를 하고 탐색 종료
                        isMax = false;
                        break;
                    }
                }

                //front 원소가 가장 큰 원소가 아니었으므로 다음 반복문 수행
                if (!isMax) continue;

                cnt++; //front 원소가 가장 큰 원소였으므로 해당 원소는 출력해야 함
                if (front[0] == M) break; //찾고자 하는 문서라면 해당 케이스는 종료
            }

            sb.append(cnt).append('\n');
        }

        System.out.println(sb);
    }

}
