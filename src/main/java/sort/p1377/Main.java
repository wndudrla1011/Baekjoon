package sort.p1377;

import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        int N = readInt();

        Data[] A = new Data[N];

        for (int i = 0; i < N; i++) {
            A[i] = new Data(readInt(), i);
        }

        Arrays.sort(A);
        int max = 0;

        for (int i = 0; i < N; i++) {
            if (max < A[i].index - i)
                max = A[i].index - i;
        }

        System.out.println(max + 1);
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}

class Data implements Comparable<Data> {
    int value;
    int index;

    public Data(int value, int index) {
        this.value = value;
        this.index = index;
    }

    @Override
    public int compareTo(Data o) {
        return this.value - o.value;
    }
}