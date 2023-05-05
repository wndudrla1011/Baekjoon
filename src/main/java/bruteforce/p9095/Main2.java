package bruteforce.p9095;

import java.io.IOException;

public class Main2 {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int T = readInt();

        while (T-- > 0) {
            int n = readInt();
            int ans = solve(0, n);

            sb.append(ans).append('\n');
        }

        System.out.println(sb);

    }

    /*
    * n을 만드는 경우의 수를 구하는 함수
    * sum : 현재까지의 합
    * */
    static int solve(int sum, int n) {
        if (sum > n) return 0; //합이 n 을 넘어서면 불가능한 경우
        if (sum == n) return 1; //합이 n이 된 경우

        int cur = 0;
        for (int i = 1; i <= 3; i++) {
            cur += solve(sum + i, n);
        }

        return cur;
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
