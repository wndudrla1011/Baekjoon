package queue.p1966;

import java.io.IOException;
import java.util.*;

public class Main2 {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue; //중요도

        int T = readInt();

        for (int i = 0; i < T; i++) {
            int N = readInt();
            int M = readInt();

            queue = new LinkedList<>();
            int[] sortedImportance = new int[N]; //정렬된 중요도를 다루기 위한 배열

            //큐와 중요도 배열 만들기
            for (int j = 0; j < N; j++) {
                int num = readInt();
                queue.add(num);
                sortedImportance[j] = num;
            }

            Arrays.sort(sortedImportance);

            int maxImportance = sortedImportance.length - 1; //배열에서 최대 중요도 값의 위치
            int order = 0; //출력 횟수
            int calCount = 0; //순서 기억

            while (true) {
                int front = queue.poll();

                if (calCount == M) front += 101; //N <= 100 이므로, 중복 값과 차별되도록 +101
                calCount++; //다음 순서로 넘어가기

                if (sortedImportance[maxImportance] == front - 101) { //M번 째가 가장 큰 중요도를 가진 경우
                    order++;
                    sb.append(order).append('\n');
                    break;
                } else if (sortedImportance[maxImportance] == front) { //front와 중복된 값
                    order++;
                    maxImportance--; //다음 중요도와 비교
                } else {
                    queue.add(front);
                }
            }
        }

        System.out.println(sb);
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
     }

}
