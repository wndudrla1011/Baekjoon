package queue.p14713;

import java.io.*;
import java.util.*;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = readInt();

        @SuppressWarnings("unchecked")
        ArrayList<String>[] Ps = new ArrayList[N]; //각 앵무새 구별
        int len = 0;

        for (int i = 0; i < N; i++) {
            String[] strArr = br.readLine().split(" ");
            ArrayList<String> P = new ArrayList<>(Arrays.asList(strArr));
            Ps[i] = P;
            len += P.size();
        }

        ArrayList<String[]> L = new ArrayList<>();
        L.add(br.readLine().split(" "));

        //모든 단어가 문장에 포함되지 않은 경우
        if (L.get(0).length != len) {
            System.out.println("Impossible");
            return;
        }

        for (int i = 0; i < L.get(0).length; i++) {
            for (int j = 0; j < N; j++) {
                if (Ps[j].size() == 0) continue; //먼저 제거된 문장
                if (L.get(0)[i].equals(Ps[j].get(0))) { //앞에서 부터 비교
                    Ps[j].remove(0); //비교 후 제거(자동 정렬)
                    break;
                }
            }
        }

        boolean flag = true;
        for (int i = 0; i < N; i++) {
            if (Ps[i].size() > 0) {
                flag = false;
                break;
            }
        }

        System.out.println(flag ? "Possible" : "Impossible");
    }

    static int readInt() throws IOException {
        int val = 0;
        do {
            int c = System.in.read();
            if (c == ' ' || c == '\n') break;
            val = 10 * val + c - 48;
        } while (true);
        return val;
    }

}
