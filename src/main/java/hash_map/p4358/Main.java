package hash_map.p4358;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> stats = new HashMap<>();
        String species;
        int total = 0;

        while ((species = br.readLine()) != null && !species.isEmpty()) {
            stats.put(species, stats.getOrDefault(species, 0) + 1);
            total += 1;
        }

        Object[] trees = stats.keySet().toArray();
        Arrays.sort(trees);

        for (Object tree : trees) {
            String per = String.format("%.4f%n", (double) stats.get(tree) / total * 100);
            sb.append(tree).append(" ").append(per);
        }

        System.out.println(sb);
    }

}
