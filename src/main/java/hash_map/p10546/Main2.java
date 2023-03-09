package hash_map.p10546;

import java.io.*;

public class Main2 {

    static int MAX_PARTICIPANT_NAME_LEN = 20;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        char[] arr = new char[MAX_PARTICIPANT_NAME_LEN + 1];

        for (int i = 0; i < 2 * N - 1; i++) { //N + N - 1
            char[] cur = br.readLine().toCharArray();
            for (int j = 0; j < cur.length; j++) {
                arr[j] ^= cur[j];
            }
        }

        int last = MAX_PARTICIPANT_NAME_LEN;
        for (int i = 0; i < MAX_PARTICIPANT_NAME_LEN; i++) {
            if (arr[i] < 'a' || arr[i] > 'z') {
                last = i;
                break;
            }
        }

        String res = String.valueOf(arr, 0, last);
        System.out.println(res);
    }

}
