package string.p1152;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cnt = 0;
        while (st.hasMoreTokens()) {
            st.nextToken();
            cnt++;
        }
        System.out.println(cnt);
    }

}
