package string.p13022;

import java.io.*;
import java.util.*;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String wolf = br.readLine();

        int wCount = 0, oCount = 0, lCount = 0, fCount = 0;
        int result = 1, index = 0;

        Queue<Character> queue = new LinkedList<>();
        char[] chars = wolf.toCharArray();
        for (char aChar : chars) {
            queue.offer(aChar);
        }

        while (!queue.isEmpty()) {
            if (index % 4 == 0) {
                if (queue.peek() != 'w') { //wolf 순서가 안 맞으면 0 출력
                    System.out.println(0);
                    return;
                }
                queue.poll();
                wCount++; //w 카운팅
                if (queue.size() > 0 && queue.peek() != 'w') index++; //다른 단어가 오기 전까지 w 모두 소거
                continue;
            }
            if (index % 4 == 1) {
                if (queue.peek() != 'o') { //wolf 순서가 안 맞으면 0 출력
                    System.out.println(0);
                    return;
                }
                queue.poll();
                oCount++;
                if (queue.size() > 0 && queue.peek() != 'o') { //다른 단어가 오기 전까지 o 모두 소거
                    if (wCount != oCount) break; //w+o+ 주기가 끝났으므로 w 개수와 o 개수가 맞는지 확인
                    index++;
                }
                continue;
            }
            if (index % 4 == 2) {
                if (queue.peek() != 'l') { //wolf 순서가 안 맞으면 0 출력
                    System.out.println(0);
                    return;
                }
                queue.poll();
                lCount++;
                if (queue.size() > 0 && queue.peek() != 'l') { //다른 단어가 오기 전까지 l 모두 소거
                    if (oCount != lCount) break; //w+o+l+ 주기가 끝났으므로 o 개수와 l 개수가 맞는지 확인
                    index++;
                }
                continue;
            }
            if (index % 4 == 3) {
                if (queue.peek() != 'f') { //wolf 순서가 안 맞으면 0 출력
                    System.out.println(0);
                    return;
                }
                queue.poll();
                fCount++;
                if (queue.size() > 0 && queue.peek() != 'f') { //다른 단어가 오기 전까지 f 모두 소거
                    if (lCount != fCount) break; //w+o+l+f+ 주기가 끝났으므로 l 개수와 f 개수가 맞는지 확인
                    wCount = 0; oCount = 0; lCount = 0; fCount = 0;
                    index++;
                }
            }
        }

        if (!(wCount == oCount && oCount == lCount && lCount == fCount)) result = 0; //모든 단어 개수 체크
        System.out.println(result);
    }

}
