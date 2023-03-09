package hash_map.p10546;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> report = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String participant = br.readLine();
            report.put(participant, report.getOrDefault(participant, 0) + 1);
        }

        String winner;
        while ((winner = br.readLine()) != null && !winner.isEmpty()) {
            report.merge(winner, -1, Integer::sum);
        }

        for (Map.Entry<String, Integer> entry : report.entrySet())
            if (entry.getValue() > 0) System.out.println(entry.getKey());
    }

}
