package string.p1152;

import java.io.*;

public class Main2 {

    public static void main(String[] args) throws IOException {
        int cnt = 0;
        int prv = ' ';
        while (true) {
            int ch = System.in.read();
            if (ch == '\n') {
                if (prv != ' ') cnt++; //마지막 단어 (개행 앞 단어)
                break;
            }
            if (ch == ' ') {
                if (prv != ' ') cnt++; //공백 사이 단어
            }
            prv = ch;
        }
        System.out.println(cnt);
    }

}
