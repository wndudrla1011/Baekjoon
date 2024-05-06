package implementation.p11723;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int S = 0;
        int M = Integer.parseInt(br.readLine());

        while (M-- > 0) {
            String command = br.readLine();

            if (command.startsWith("add")) {
                int num = Integer.parseInt(command.substring(4));
                S |= (1 << num);
            } else if (command.startsWith("remove")) {
                int num = Integer.parseInt(command.substring(7));
                S &= ~(1 << num);
            } else if (command.startsWith("check")) {
                int num = Integer.parseInt(command.substring(6));
                sb.append((S & (1 << num)) != 0 ? "1\n" : "0\n");
            } else if (command.startsWith("toggle")) {
                int num = Integer.parseInt(command.substring(7));
                S ^= (1 << num);
            } else if (command.startsWith("all")) {
                S = (1 << 21) - 1;
            } else S = 0;
        }

        System.out.println(sb);
    }

}
