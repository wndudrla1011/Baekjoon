package math.p2023;

import java.io.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        //일의 자리 소수는 2,3,5,7
        DFS(2, 1);
        DFS(3, 1);
        DFS(5, 1);
        DFS(7, 1);

        System.out.println(sb);
    }

    static void DFS(int number, int jarisu) {
        if (jarisu == N) {
            sb.append(number).append('\n');
            return;
        }

        for (int i = 1; i < 10; i++) {
            if (i % 2 == 0) //짝수라면 소수가 될 수 없음
                continue;
            if (isPrime(number * 10 + i)) //소수라면
                DFS(number * 10 + i, jarisu + 1); //자릿수 증가
        }
    }


    static boolean isPrime(int num) {
        for (int i = 2; i * i <= num; i++)
            if (num % i == 0)
                return false;
        return true;
    }

}
