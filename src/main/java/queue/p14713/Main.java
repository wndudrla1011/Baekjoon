package queue.p14713;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = readInt();
        Queue<String>[] word = new Queue[N];
        int len = 0;

        for (int i = 0; i < N; i++) {
            word[i] = new LinkedList<>();
            String[] s = br.readLine().split(" ");
            for (String contents : s) word[i].add(contents);
            len += word[i].size();
        }

        String[] L = br.readLine().split(" ");

        //모든 단어가 문장에 포함되지 않은 경우
        if (L.length != len) {
            System.out.println("Impossible");
            return;
        }

        for (String note : L) {
            boolean flag = false;
            for (int i = 0; i < N; i++) {
                if (Objects.equals(word[i].peek(), note)) {
                        word[i].poll();
                        flag = !flag;
                }
            }
            if (!flag) { //단어 순서에 맞는 문장이 아닌 경우
                System.out.println("Impossible");
                return;
            }
        }

        System.out.println("Possible");
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
