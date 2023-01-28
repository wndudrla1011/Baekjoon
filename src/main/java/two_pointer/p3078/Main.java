package two_pointer.p3078;

import java.io.*;
import java.util.*;

public class Main {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer>[] queue = new Queue[21];
        for (int i = 0; i < 21; i++)
            queue[i] = new LinkedList<>();

        long bf = 0;
        for (int i = 0; i < N; i++) {
            int length = br.readLine().trim().length();

            if (queue[length].isEmpty()) {
                queue[length].offer(i);
            } else {
                /*
                 * 이름 길이가 같은 학생 간 성적 차 비교
                 * 조건을 만족하는 학생을 추가
                 * peek() : 인덱스가 뒤쪽인 학생 (앞으로 들어오는 인덱스와 가까움)
                 * */
                while (i - queue[length].peek() > K) {
                    queue[length].poll();
                    if (queue[length].isEmpty()) break;
                }

                bf += queue[length].size();
                queue[length].offer(i); //다음 비교를 위해 큐에 추가
            }
        }

        System.out.println(bf);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

}
