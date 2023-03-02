package hash_map.p5568;

import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int k;
    static int[] card;
    static boolean[] visited;
    static HashSet<Integer> hs = new HashSet<>();

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        n = readInt();
        k = readInt();

        card = new int[n];
        for (int i = 0; i < n; i++) card[i] = readInt();

        visited = new boolean[n];
        pick_module(0, 0);

        sb.append(hs.size()).append('\n');
        System.out.println(sb);
    }

    public static void pick_module(int remain, int num) {
        if (remain == k) {
            hs.add(num);
            return;
        }
        for (int i = 0; i < n; i++) {
            int tempNum = num;
            if (!visited[i]) {
                visited[i] = true;

                if (card[i] > 9) tempNum = tempNum * 100 + card[i]; //2자리 이상 -> 자리 2개 필요
                else tempNum = tempNum * 10 + card[i]; //1자리 -> 자리 1개 필요

                pick_module(remain + 1, tempNum);
                visited[i] = false;
            }
        }
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
