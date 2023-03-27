package sort.p1377;

import java.io.IOException;

public class Main2 {

    public static void main(String[] args) throws IOException {
        int N = readInt();

        int[] A = new int[N + 1];
        int[] l = new int[1000001];

        for (int i = 0; i < N; i++) {
            A[i] = readInt();
            l[A[i]]++;
        }

        int s = 0, m = 0;

        //Arrays.sort() 효과 -> index 정렬
        for (int i = 0; i <= 1000000; i++) {
            s += l[i];
            l[i] = s - 1;
        }

        for (int i = 0; i < N; i++) {
            m = Math.max(m, i - l[A[i]]);
        }

        System.out.println(m + 1);
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}

