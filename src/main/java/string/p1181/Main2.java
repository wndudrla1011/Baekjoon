package string.p1181;

import java.io.*;
import java.util.Arrays;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];

        for (int i = 0; i < N; i++)
            arr[i] = br.readLine();

        Arrays.sort(arr, (o1, o2) -> {
            if (o1.length() == o2.length()) return o1.compareTo(o2);
            else return o1.length() - o2.length();
        });

        for (int i = 0; i < N; i++) {
            bw.write(arr[i]);
            bw.newLine();

            while (i + 1 < N && arr[i].equals(arr[i + 1])) i++; //단어 중복 검사(중복이 아닐 때까지 i 증가)
        }
        bw.flush();
    }

}
