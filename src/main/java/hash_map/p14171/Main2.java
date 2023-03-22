package hash_map.p14171;

import java.io.*;
import java.util.*;

class City {
    String name;
    int index;

    public City(String name, int index) {
        this.name = name;
        this.index = index;
    }
}

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int ans = 0;
        int currIndex = 0;
        City[] cities = new City[N]; //city + index
        Map<String, Integer> map = new HashMap<>(); //state + index

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken().substring(0, 2);
            String index = st.nextToken();
            if (!map.containsKey(index)) map.put(index, currIndex++); //state code + index
            cities[i] = new City(name, map.get(index)); //city code + index
        }

        int[][] adjs = new int[currIndex][currIndex];
        for (int i = 0; i < N; i++) {
            City city = cities[i];
            if (map.containsKey(city.name)) ++adjs[city.index][map.get(city.name)]; //대칭 배치
        }

        for (int i = 0; i < currIndex; i++) {
            for (int j = 0; j < currIndex; j++) {
                if (i == j) continue; //city == state 인 경우
                ans += adjs[i][j] * adjs[j][i];
            }
        }

        System.out.println(ans / 2);
    }

}
