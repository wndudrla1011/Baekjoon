package math.p1271;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        BigInteger big1 = new BigInteger(st.nextToken());
        BigInteger big2 = new BigInteger(st.nextToken());

        System.out.println(big1.divide(big2));
        System.out.println(big1.remainder(big2));
    }

}
