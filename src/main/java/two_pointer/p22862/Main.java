package two_pointer.p22862;

import java.io.*;

public class Main {

    static int N, K;
    static int[] arr;
    static int max;
    static int count;
    static boolean[] check;
    static int left = 1, right = 1;

    public static void main(String[] args) throws IOException {
        N = readInt();
        K = readInt();
        check = new boolean[N + 1];

        arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            int num = readInt();
            arr[i] = num;
            if (num % 2 == 0) check[i] = true; //입력 값 짝수 : true, 홀수 : false
        }

        solve();
        System.out.println(max);
    }

    public static void solve() {
        while (right <= N) {
            if (count < K) { //K보다 홀수 개수가 적음
                if (!check[right]) count++; //홀수 카운팅
                right++; //이것을 하지 않으면 max 계산 시, +1해야 함
                max = Math.max(max, right - left - count); //길이에서 홀수 개수 제외
            } else if (check[right]) { //count == K 이지만 짝수이므로 더 길게 가능
                right++;
                max = Math.max(max, right - left - count); //길이에서 홀수 개수 제외
            } else if (count == K && !check[right]) { //count == K이고, 뒤의 수도 홀수이므로 중지
                //first가 있던 위치의 수가 홀수일 때 count를 낮추고, 아닌 경우에는 놔둔다.
                if (!check[left]) count--; //left 위치 값이 홀수이면 홀수가 빠지므로 count--
                left++;
            }
        }
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
