package hash_map.p7785;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String status = st.nextToken();

            if (status.equals("enter")) set.add(name);
            else set.remove(name);
        }

        ArrayList<String> list = new ArrayList<>(set);
        list.sort(Comparator.reverseOrder());

        for (String s : list) sb.append(s).append('\n');
        System.out.println(sb);
    }

}