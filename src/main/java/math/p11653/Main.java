package math.p11653;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        int N = readInt();
        StringBuilder sb = new StringBuilder();

        if (N == 1)
            return;

        while (true) {
            int result = isPrime(N);
            if (result < 0) // 소수 -> 종료
                break;

            else { // 소수x
                sb.append(result).append("\n");
                N /= result;
            }
        }

        sb.append(N).append("\n"); // 나머지

        System.out.println(sb);
    }

    static int isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) { // 소수 x
                return i;
            }
        }
        return -1;
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
