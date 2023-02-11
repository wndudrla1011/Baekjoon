package queue.p1158;

import java.io.IOException;

public class Main2 {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int N = readInt();
        int K = readInt();
        int index = K - 1;

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = i + 1;

        sb.append("<").append(arr[index]);

        System.arraycopy(arr, index + 1, arr, index, --N - index);
        while (N > 0) {
            index = (index + K - 1) % N;
            sb.append(", ").append(arr[index]);
            System.arraycopy(arr, index + 1, arr, index, --N - index);
        }

        sb.append(">");
        System.out.println(sb);
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = (System.in.read())) > 32)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
