package hash_map.p2776;

import java.io.*;
import java.util.*;

public class Main {

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

      int T = Integer.parseInt(br.readLine());
      while (T-- > 0) {
         Set<Integer> note1 = new HashSet<>();
         int N = Integer.parseInt(br.readLine());

         StringTokenizer st = new StringTokenizer(br.readLine());
         for (int i = 0; i < N; i++) note1.add(Integer.parseInt(st.nextToken()));

         int M = Integer.parseInt(br.readLine());
         st = new StringTokenizer(br.readLine());
         while (M-- > 0) {
            if (note1.contains(Integer.parseInt(st.nextToken()))) bw.write("1\n");
            else bw.write("0\n");
         }
      }
      bw.flush();
      bw.close();
      br.close();
   }

}
