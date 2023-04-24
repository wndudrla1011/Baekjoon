package bruteforce.p2309;

import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int[] heights = new int[9];
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            heights[i] = readInt();
        }

        op:for (int a = 0; a < 3; a++) {
            for (int b = a + 1; b < 4; b++) {
                for (int c = b + 1; c < 5; c++) {
                    for (int d = c + 1; d < 6; d++) {
                        for (int e = d + 1; e < 7; e++) {
                            for (int f = e + 1; f < 8; f++) {
                                for (int g = f + 1; g < 9; g++) {
                                    if (heights[a] + heights[b] + heights[c] + heights[d] + heights[e] + heights[f] + heights[g] == 100) {
                                        ans.add(heights[a]);
                                        ans.add(heights[b]);
                                        ans.add(heights[c]);
                                        ans.add(heights[d]);
                                        ans.add(heights[e]);
                                        ans.add(heights[f]);
                                        ans.add(heights[g]);
                                        break op;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        Collections.sort(ans);

        for (int a : ans) {
            sb.append(a).append('\n');
        }

        System.out.println(sb);
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
