package bruteforce.p1107;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        int N = readInt();
        boolean[] broken = new boolean[10];
        int M = readInt();

        for (int i = 0; i < M; i++) {
            int breakdown = readInt();
            broken[breakdown] = true;
        }

        int result = Math.abs(N - 100); //초기값 설정
        for (int i = 0; i <= 999999; i++) {
            String str = String.valueOf(i);
            int len = str.length();

            boolean isBreak = false;
            for (int j = 0; j < len; j++) {
                if (broken[str.charAt(j) - '0']) { //고장난 버튼을 눌러야 한다면
                    isBreak = true;
                    break; //탐색 종료
                }
            }
            if (!isBreak) { //i를 누를 때 고장난 버튼을 누르지 않는다면
                int min = Math.abs(N - i) + len; //i를 누른 후(len) N까지 이동하는 횟수(N - i)
                result = Math.min(min, result);
            }
        }

        System.out.println(result);
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
