package string.p2675;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb;

        int T = Integer.parseInt(st.nextToken());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            String str = st.nextToken();

            sb = new StringBuilder();

            for (String s : str.split("")) sb.append(s.repeat(R));
            System.out.println(sb);
        }
    }

}
