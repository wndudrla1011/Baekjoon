package bruteforce.p6064;

import java.io.IOException;

public class Main2 {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int T = readInt();

        while (T-- > 0) {
            int M = readInt();
            int N = readInt();
            int x = readInt();
            int y = readInt();

            int year = x;
            int last = lcm(M, N);

            while (true) {
                //해가 최소 공배수보다 크면 -1
                if (year > last) {
                    sb.append(-1).append('\n');
                    break;
                }

                //year % N = y
                else if (((year % N) == 0 ? N : (year % N)) == y) {
                    sb.append(year).append('\n');
                    break;
                }

                year += M;
            }
        }

        System.out.println(sb);
    }

    static int lcm(int A, int B) {
        return A * B / gcd(A, B);
    }

    static int gcd(int A, int B) {
        if (B == 0) return A;
        return gcd(B, A % B);
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
