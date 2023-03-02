package hash_map.p7785;

import java.io.*;
import java.util.*;

public class Main3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        TreeSet<String> set = new TreeSet<>();

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String status = st.nextToken();

            if (status.equals("enter")) set.add(name);
            else set.remove(name);
        }

        for (Iterator<String> itr = set.descendingIterator(); itr.hasNext(); ) {
            sb.append(itr.next()).append('\n');
        }

        System.out.println(sb);
    }

}