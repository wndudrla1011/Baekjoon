package sort.p11650;

import java.io.*;
import java.util.*;

class Coordinates {
    int x;
    int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    public void solution() throws Exception {
        StringBuilder sb = new StringBuilder();
        int N = nextInt();
        Coordinates[] coordinates = new Coordinates[N];

        for (int i = 0; i < N; i++)
            coordinates[i] = new Coordinates(nextInt(), nextInt());

        Arrays.sort(coordinates, (o1, o2) -> {
            if (o1.x == o2.x) return o1.y - o2.y;
            else return o1.x - o2.x;
        });

        for (int i = 0; i < N; i++)
            sb.append(coordinates[i].x).append(" ").append(coordinates[i].y).append('\n');

        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        initFI();
        new Main().solution();
    }

    private static final int DEFAULT_BUFFER_SIZE = 1 << 16;
    private static DataInputStream inputStream;
    private static byte[] buffer;
    private static int curIdx, maxIdx;

    private static void initFI() {
        inputStream = new DataInputStream(System.in);
        buffer = new byte[DEFAULT_BUFFER_SIZE];
        curIdx = maxIdx = 0;
    }

    private static int nextInt() throws IOException {
        int ret = 0;
        byte c = read();
        while (c <= ' ') c = read();
        boolean neg = (c == '-');
        if (neg) c = read();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
        if (neg) return -ret;
        return ret;
    }

    private static byte read() throws IOException {
        if (curIdx == maxIdx) {
            maxIdx = inputStream.read(buffer, curIdx = 0, DEFAULT_BUFFER_SIZE);
            if (maxIdx == -1) buffer[0] = -1;
        }
        return buffer[curIdx++];
    }

}