package deque.p1021;

import java.io.*;
import java.util.*;

public class Main2 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] targets = new int[M];
        int size = N, end = N, start = 1;
        int cnt = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) targets[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            int k = targets[i];
            int left = k - start; //맨 좌측과의 거리
            int right = end - k + 1; //맨 우측과의 거리

            if (left <= right) { //좌회전 (OP 2)
                cnt += left;
                for (int j = i + 1; j < M; j++) {
                    if (targets[j] < k) targets[j] = targets[j] + end - k + 1; //왼쪽에 위치
                    else targets[j] = targets[j] - left; //오른쪽에 위치
                }
            }
            else { //우회전 (OP 3)
                cnt += right;
                for (int j = i + 1; j < M; j++) {
                    if (targets[j] < k) targets[j] = targets[j] + right; //왼쪽에 위치
                    else targets[j] = start + targets[j] - k; //오른쪽에 위치
                }
            }
            start += 1; //OP 1
        }

        System.out.println(cnt);
    }

}
