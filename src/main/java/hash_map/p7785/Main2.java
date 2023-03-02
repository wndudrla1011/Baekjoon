package hash_map.p7785;

import java.io.*;
import java.util.*;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String status = st.nextToken();

            if (status.equals("enter")) map.put(name, 1);
            else map.remove(name);
        }

        List<String> list = new ArrayList<>(map.keySet());
        list.sort(Comparator.reverseOrder());

        for (String name : list) sb.append(name).append('\n');
        System.out.println(sb);
    }

}