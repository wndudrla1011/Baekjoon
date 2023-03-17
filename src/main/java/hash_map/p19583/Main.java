package hash_map.p19583;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String S = st.nextToken(); //start time
        String E = st.nextToken(); //end time
        String Q = st.nextToken(); //streaming end time

        Set<String> tmp = new HashSet<>(); //임시 출석
        Set<String> pmt = new HashSet<>(); //영구 출석

        int start_h = Integer.parseInt(S.split(":")[0]); //시작 시
        int start_m = Integer.parseInt(S.split(":")[1]); //시작 분

        int end_h = Integer.parseInt(E.split(":")[0]); //종료 시
        int end_m = Integer.parseInt(E.split(":")[1]); //종료 분

        int streaming_end_h = Integer.parseInt(Q.split(":")[0]); //스트리밍 종료 시
        int streaming_end_m = Integer.parseInt(Q.split(":")[1]); //스트리밍 종료 분

        String chat_report;
        while ((chat_report = br.readLine()) != null && !chat_report.isEmpty()) {
            String[] chat = chat_report.split(" ");
            int chat_time_h = Integer.parseInt(chat[0].split(":")[0]); //채팅 시
            int chat_time_m = Integer.parseInt(chat[0].split(":")[1]); //채팅 분

            String chat_nick = chat[1];

            if (start_h > chat_time_h || (start_h == chat_time_h && start_m >= chat_time_m)) {
                tmp.add(chat_nick); //입장 인정
            }

            else if (end_h < chat_time_h || (end_h == chat_time_h && end_m <= chat_time_m)) {
                if (streaming_end_h > chat_time_h || (streaming_end_h == chat_time_h && streaming_end_m >= chat_time_m)) {
                    if (tmp.contains(chat_nick)) pmt.add(chat_nick); //출석 인정
                }
            }
        }

        System.out.println(pmt.size());
    }

}
