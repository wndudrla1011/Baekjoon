package bruteforce.p1748;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int len = 0; //자릿 수
        int tmp = N;
        int ans = 0;

        while (tmp != 0) {
            tmp /= 10;
            len++;
        }

        int square = len - 1; //제곱값

        ans += (N - Math.pow(10, square--) + 1) * len--;

        while (square >= 0) {
            ans += (9 * Math.pow(10, square--)) * len--;
        }

        System.out.println(ans);
    }

}
