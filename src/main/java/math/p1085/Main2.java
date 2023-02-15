package math.p1085;

import java.io.IOException;

public class Main2 {

    public static void main(String[] args) throws IOException {
        int x = readInt();
        int y = readInt();
        int w = readInt();
        int h = readInt();

        int[] arr = {w - x, y, h - y};
        int min = x;
        for (int i = 0; i < 3; i++)
            if (min > arr[i]) min = arr[i];

        System.out.println(min);
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read())>32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
