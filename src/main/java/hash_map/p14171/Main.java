package hash_map.p14171;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int ans = 0;
        String[] arr = new String[N];
        Map<String, Integer> map = new HashMap<>(); //state + index

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String cityCode = st.nextToken().substring(0, 2);
            String stateCode = st.nextToken();

            arr[i] = cityCode + stateCode;
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        for (int i = 0; i < N; i++) {
            String rStr = arr[i].substring(2) + arr[i].substring(0, 2);
            if (arr[i].equals(rStr)) continue; //city == state
            ans += map.getOrDefault(rStr, 0);
        }

        System.out.println(ans / 2);
    }

}
