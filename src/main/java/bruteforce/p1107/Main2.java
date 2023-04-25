package bruteforce.p1107;

import java.io.IOException;

public class Main2 {

    static boolean[] broken;

    public static void main(String[] args) throws IOException {
        int N = readInt();
        broken = new boolean[10];
        int M = readInt();

        for (int i = 0; i < M; i++) {
            int breakdown = readInt();
            broken[breakdown] = true;
        }

        int result = Math.abs(N - 100); //초기값 설정
        for (int i = 0; i <= 999999; i++) {
            int len = check(i); //해당 숫자를 위한 클릭 횟수

            if (len > 0) { //숫자(i)에 고장난 번호가 포함되지 않은 경우
                int min = Math.abs(N - i) + len; //i를 누른 후(len) N까지 이동하는 횟수(N - i)
                result = Math.min(min, result);
            }
        }

        System.out.println(result);
    }

    /*
    * x 라는 숫자를 클릭하기 위한 버튼 클릭 횟수 조사
    * */
    static int check(int x) {
        if (x == 0) {
            if (broken[0]) return 0;
            else return 1;
        }

        int ans = 0;
        while (x > 0) {
            if (broken[x % 10]) return 0;
            x /= 10;
            ans++;
        }

        return ans;
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
