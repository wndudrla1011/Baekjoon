package binary_search.p2343;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        int N = readInt();
        int M = readInt();
        int[] A = new int[N];
        int start = 0, end = 0;

        for (int i = 0; i < N; i++) {
            A[i] = readInt();
            if (start < A[i]) start = A[i]; //레슨 최댓값을 시작 인덱스로 저장
            end = end + A[i]; //모든 레슨의 총합을 종료 인덱스로 저장
        }

        while (start <= end) {
            int mid = (start + end) / 2; //블루레이 크기
            int sum = 0; //레슨 합
            int cnt = 0; //현재 사용한 블루레이 개수
            for (int i = 0; i < N; i++) {
                if (sum + A[i] > mid) { //블루레이 크기 내로 최대한 담기
                    cnt++;
                    sum = 0;
                }
                sum += A[i];
            }
            if (sum != 0) //마지막 레슨 담기
                cnt++;
            if (cnt > M) //블루레이 크기(mid)를 늘여야 함
                start = mid + 1;
            else //블루레이 크기(mid)를 줄여야 함
                end = mid - 1;
        }

        System.out.println(start);
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
