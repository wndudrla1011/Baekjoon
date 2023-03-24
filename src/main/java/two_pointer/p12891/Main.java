package two_pointer.p12891;

import java.io.*;
import java.util.*;

public class Main {

    static int[] checkArr = new int[4]; //비밀번호 체크 배열
    static int[] myArr = new int[4]; //현재 상태 배열
    static int answer = 0; //만들 수 있는 비밀번호 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken()); //문자열의 길이
        int P = Integer.parseInt(st.nextToken()); //부분 문자열의 길이
        char[] DNA = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < P; i++) { //초기 부분 문자열 셋팅
            if (DNA[i] == 'A') myArr[0]++;
            if (DNA[i] == 'C') myArr[1]++;
            if (DNA[i] == 'G') myArr[2]++;
            if (DNA[i] == 'T') myArr[3]++;
        }

        if (checkCounting()) //{'A', 'C', 'G', 'T'} 문자가 모두 최소 개수를 만족했다면
            answer++;

        for (int i = P; i < S; i++) {
            int j = i - P; //이전 부분 문자열의 시작 위치

            //이전 부분 문자열의 시작 문자 제외
            if (DNA[j] == 'A') myArr[0]--;
            if (DNA[j] == 'C') myArr[1]--;
            if (DNA[j] == 'G') myArr[2]--;
            if (DNA[j] == 'T') myArr[3]--;

            //이전 부분 문자열에 새 문자 추가
            if (DNA[i] == 'A') myArr[0]++;
            if (DNA[i] == 'C') myArr[1]++;
            if (DNA[i] == 'G') myArr[2]++;
            if (DNA[i] == 'T') myArr[3]++;

            if (checkCounting()) answer++;
        }

        System.out.println(answer);
        br.close();
    }

    private static boolean checkCounting() {
        for (int i = 0; i < 4; i++) {
            if (myArr[i] < checkArr[i]) return false;
        }
        return true;
    }

}
