package string.p2675;

import java.io.*;
import java.util.StringTokenizer;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        char[] resultArr;

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            char[] arr = st.nextToken().toCharArray();

            resultArr = new char[R * arr.length];

            int idx = 0;
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < R; j++) {
                    resultArr[idx++] = arr[i];
                }
            }

            for (int i = 0; i < resultArr.length; i++)
                System.out.print(resultArr[i]);
            System.out.println();
        }
    }

}
