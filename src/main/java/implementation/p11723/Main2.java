package implementation.p11723;

import java.io.*;
import java.util.*;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Set<Integer> S = new HashSet<>();
        int M = Integer.parseInt(br.readLine());

        while (M-- > 0) {
            String command = br.readLine();

            if (command.startsWith("add")) {
                int num = Integer.parseInt(command.substring(4));
                S.add(num);
            } else if (command.startsWith("remove")) {
                int num = Integer.parseInt(command.substring(7));
                S.remove(num);
            } else if (command.startsWith("check")) {
                int num = Integer.parseInt(command.substring(6));
                if (S.contains(num)) sb.append("1\n");
                else sb.append("0\n");
            } else if (command.startsWith("toggle")) {
                int num = Integer.parseInt(command.substring(7));
                if (S.contains(num)) S.remove(num);
                else S.add(num);
            } else if (command.startsWith("all")) {
                for (int i = 1; i <= 20; i++) {
                    S.add(i);
                }
            } else S.clear();
        }

        System.out.println(sb);
    }

}
