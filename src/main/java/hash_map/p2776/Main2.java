package hash_map.p2776;

import java.io.*;
import java.util.*;

public class Main2 {

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

      int T = Integer.parseInt(br.readLine());
      while (T-- > 0) {
         int N = Integer.parseInt(br.readLine());

         int[] note1 = new int[N];
         StringTokenizer st = new StringTokenizer(br.readLine());
         for (int i = 0; i < N; i++) note1[i] = Integer.parseInt(st.nextToken());

         Arrays.sort(note1);

         int M = Integer.parseInt(br.readLine());
         st = new StringTokenizer(br.readLine());
         while (M-- > 0) {
            int target = Integer.parseInt(st.nextToken());
            int left = 0, right = N - 1;
            boolean find = false;
            while (left <= right) {
               int mid = (left + right) / 2;
               if (note1[mid] < target) left = mid + 1;
               else if (note1[mid] > target) right = mid - 1;
               else {
                  find = true;
                  break;
               }
            }
            if (find) bw.write("1\n");
            else bw.write("0\n");
         }
      }
      bw.flush();
      bw.close();
      br.close();
   }

}
