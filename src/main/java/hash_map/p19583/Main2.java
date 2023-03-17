package hash_map.p19583;

import java.io.*;
import java.util.*;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int[] S = new int[2];
        int[] E = new int[2];
        int[] Q = new int[2];

        S[0] = (str.charAt(0) - '0') * 10 + str.charAt(1) - '0'; //start time hour
        S[1] = (str.charAt(3) - '0') * 10 + str.charAt(4) - '0'; //start time minute
        E[0] = (str.charAt(6) - '0') * 10 + str.charAt(7) - '0'; //end time hour
        E[1] = (str.charAt(9) - '0') * 10 + str.charAt(10) - '0'; //end time minute
        Q[0] = (str.charAt(12) - '0') * 10 + str.charAt(13) - '0'; //streaming end time hour
        Q[1] = (str.charAt(15) - '0') * 10 + str.charAt(16) - '0'; //streaming end time minute

        Map<String, int[]> map = new HashMap<>();
        int ans = 0;

        String chat_report;
        while ((chat_report = br.readLine()) != null && !chat_report.isEmpty()) {
            int[] chat_time = new int[2];
            chat_time[0] = (chat_report.charAt(0) - '0') * 10 + chat_report.charAt(1) - '0'; //채팅 시
            chat_time[1] = (chat_report.charAt(3) - '0') * 10 + chat_report.charAt(4) - '0'; //채팅 분

            if (S[0] > chat_time[0] || (S[0] == chat_time[0] && S[1] >= chat_time[1])) {
                map.put(chat_report.substring(6), chat_time); //입장 인정
            }

            else if (E[0] < chat_time[0] || (E[0] == chat_time[0] && E[1] <= chat_time[1])) {
                if (Q[0] > chat_time[0] || (Q[0] == chat_time[0] && Q[1] >= chat_time[1])) {
                    if (map.containsKey(chat_report.substring(6))) {
                        map.remove(chat_report.substring(6)); //출석 체크
                        ans++;
                    }
                }
            }
        }

        System.out.println(ans);
    }

}
