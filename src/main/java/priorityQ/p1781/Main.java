package priorityQ.p1781;

import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        int N = readInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>(); //최대 라면 개수
        Homework[] homeworkArr = new Homework[N];

        for (int i = 0; i < N; i++) {
            int DL = readInt();
            int ramen = readInt();
            homeworkArr[i] = new Homework(DL, ramen);
        }

        long currentRamenCnt = 0;
        Arrays.parallelSort(homeworkArr); //Comparable interface overriding 조건에 따라 정렬

        for (Homework hw : homeworkArr) {
            int date = pq.size(); //마감 날짜

            if (date < hw.deadline) pq.offer(hw.ramenCnt); //마감 날짜가 되지 않음
            else if (date == hw.deadline) { //마감 날짜가 같은 것 중
                int noodleCount = pq.peek(); //앞에 받은 컵라면보다
                if (noodleCount < hw.ramenCnt) { //더 많은 컵라면을 받을 수 있는가
                    pq.poll();
                    pq.offer(hw.ramenCnt);
                }
            }
        }

        while (!pq.isEmpty()) currentRamenCnt += pq.poll();

        System.out.println(currentRamenCnt);
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}

class Homework implements Comparable<Homework> {
    int deadline;
    int ramenCnt;

    public Homework(int deadline, int ramenCnt) {
        this.deadline = deadline;
        this.ramenCnt = ramenCnt;
    }

    @Override
    public int compareTo(Homework target) {
        if (this.deadline == target.deadline) return target.ramenCnt - this.ramenCnt;
        else return this.deadline - target.deadline;
    }
}
