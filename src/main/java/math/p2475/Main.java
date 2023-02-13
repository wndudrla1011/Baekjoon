package math.p2475;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int validation = 0;

        while (st.hasMoreTokens())
            validation += Math.pow(Integer.parseInt(st.nextToken()), 2);

        System.out.println(validation % 10);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

}
