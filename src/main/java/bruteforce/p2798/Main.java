package bruteforce.p2798;

import java.io.IOException;

public class Main {

    static int N;
    static int M;
    static boolean[] checked;
    static int[] card;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        N = readInt();
        M = readInt();

        checked = new boolean[N];
        card = new int[N];
        for (int i = 0; i < N; i++) card[i] = readInt();

        pick(0, 0, 0);
        System.out.println(max);
    }

    static void pick(int selected, int sum, int start) {
        if (selected == 3) {
            if (max < sum && sum <= M) {
                max = sum;
//                if (max == 21) {
//                    System.out.println(max);
//                    System.exit(0);
//                }
            }
            return;
        }

        for (int i = start; i < N; i++) {
            if (!checked[i]) {
                sum += card[i];
                checked[i] = true;
                pick(selected + 1, sum, i + 1);
                sum -= card[i];
                checked[i] = false;
            }
        }
    }

    static int readInt() throws IOException {
        int c, n = 0;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
