package math.p10951;

import java.io.BufferedReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        int c, sum;
        while (true) {
            sum = 0;
            while ((c = System.in.read()) >= 32) {
                if (c == 32) continue;
                sum += (c - '0');
            }
            if (sum == 0) break;
            System.out.println(sum);
        }
    }

}
