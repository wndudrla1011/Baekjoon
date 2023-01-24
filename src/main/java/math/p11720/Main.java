package math.p11720;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] arr = br.readLine().split("");

        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += Integer.parseInt(arr[i]);

        System.out.println(sum);
    }

}
