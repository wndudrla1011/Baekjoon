package math.p1978;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        int N = readInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = readInt();

        Arrays.sort(arr);

        int cnt = 0;
        List<Integer> prime = new ArrayList<>();

        int last = arr[N - 1];
        for (int i = 1; i <= last; i++) prime.add(i);

        for (int i = 2; i <= Math.sqrt(last); i++) {
            int j = 2;
            while (i * j <= last) {
                prime.remove(Integer.valueOf(i * j));
                j++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) continue;
            if (prime.contains(arr[i])) cnt++;
        }

        System.out.println(cnt);
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
