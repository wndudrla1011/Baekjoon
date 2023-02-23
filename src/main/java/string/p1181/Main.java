package string.p1181;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Word> pq = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        while (N-- > 0) {
            String word = br.readLine();
            set.add(word);
        }

        for (String s : set)
            pq.offer(new Word(s.length(), s));

        while (!pq.isEmpty()) sb.append(pq.poll().word).append('\n');
        System.out.println(sb);
    }

}

class Word implements Comparable<Word> {
    int len;
    String word;

    public Word(int len, String word) {
        this.len = len;
        this.word = word;
    }

    @Override
    public int compareTo(Word o) {
        if (this.len == o.len) return this.word.compareTo(o.word);
        else return this.len - o.len;
    }
}