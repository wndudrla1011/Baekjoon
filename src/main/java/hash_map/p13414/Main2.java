package hash_map.p13414;

import java.io.*;
import java.util.*;

public class Main2 {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Set<String> waiting = new LinkedHashSet<>();
        String[] code = new String[L];
        for (int i = 0; i < L; i++) {
            code[i] = br.readLine();
        }

        for (int i = L - 1; i >= 0; i--) {
            waiting.add(code[i]);
        }

        List<String> list = new ArrayList<>(waiting);

        for (int i = list.size() - 1, count = 0; i >= 0; i--, count++) {
            if (count == K) break;
            sb.append(list.get(i)).append('\n');
        }

        System.out.println(sb);
    }

}
