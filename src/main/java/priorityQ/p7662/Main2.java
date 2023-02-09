package priorityQ.p7662;

import java.io.*;
import java.util.*;

public class Main2 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static Queue<Element> minQ = new PriorityQueue<>();
    static Queue<Element> maxQ = new PriorityQueue<>(Collections.reverseOrder());

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int k = Integer.parseInt(br.readLine());
            while (k-- > 0) {
                st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                if (command.equals("I")) insert(num);
                else delete(num);
            }
            Element min;
            Element max;
            boolean run = true;
            //exist가 true인 값이 나올 때까지 반복 -> 존재하는 값 중 최솟값
            while (true) {
                min = minQ.poll();
                if (min == null) { //큐가 비었을 경우
                    run = false;
                    break;
                }
                if (min.isExist()) break;
                else continue;
            }

            //exist가 true인 값이 나올 때까지 반복 -> 존재하는 값 중 최댓값
            while (true) {
                max = maxQ.poll();
                if (max == null) { //큐가 비었을 경우
                    run = false;
                    break;
                }
                if (max.isExist()) break;
                else continue;
            }

            if (run) bw.write(max.getNum() + " " + min.getNum() + "\n");
            else bw.write("EMPTY\n");

            minQ.clear();
            maxQ.clear();
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void insert(int num) {
        Element e = new Element(num, true);
        minQ.add(e);
        maxQ.add(e);
    }

    public static void delete(int num) {
        if (minQ.size() == 0) return;
        if (num == 1) { //최댓값
            while (true) {
                Element e = maxQ.poll();
                if (e == null) break;
                if (e.isExist()) {
                    e.setExist(false); //poll() 후에는 존재하지 않으므로 스위칭
                    break;
                }
                else continue;
            }
        } else { //최솟값
            while (true) {
                Element e = minQ.poll();
                if (e == null) break;
                if (e.isExist()) {
                    e.setExist(false); //poll() 후에는 존재하지 않으므로 스위칭
                    break;
                }
                else continue;
            }
        }
    }

}

class Element implements Comparable<Element> {
    private int num;
    private boolean exist;

    public Element(int num, boolean exist) {
        this.setNum(num);
        this.setExist(exist);
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setExist(boolean exist) {
        this.exist = exist;
    }

    public boolean isExist() {
        return exist;
    }

    @Override
    public int compareTo(Element o) {
        if (this.getNum() > o.getNum()) return 1;
        else if (this.getNum() < o.getNum()) return -1;
        else return 0;
    }
}