package math.p2108;

import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int N = readInt();
        double sum = 0;

        int[] arr = new int[N];
        int[] check = new int[8001]; //음수 : 1~4000, 양수 : 4001~8000

        for (int i = 0; i < N; i++) {
            arr[i] = readInt();
            if (arr[i] <= 0) check[Math.abs(arr[i])]++;
            else if (arr[i] > 0) check[4000 + arr[i]]++;
            sum += arr[i];
        }

        Arrays.sort(arr);

        sb.append(Math.round(sum / N)).append('\n'); //산술평균
        sb.append(arr[N / 2]).append('\n'); //중앙값

        int max = Integer.MIN_VALUE, frequent = 0;
        int number = 0, prv = 4001;
        for (int i = 0; i < N; i++) {
            if (prv == arr[i]) continue; //중복 값 제외
            if (arr[i] <= 0) {
                if (max <= check[Math.abs(arr[i])]) {
                    if (max == check[Math.abs(arr[i])]) number++;
                    else number = 1;
                    max = check[Math.abs(arr[i])];
                    if (number <= 2) frequent = arr[i]; //중복 최빈값이 있다면 2번째로 작은 값
                }
            }
            else {
                if (max <= check[4000 + arr[i]]) {
                    if (max == check[4000 + arr[i]]) number++;
                    else number = 1;
                    max = check[4000 + arr[i]];
                    if (number <= 2) frequent = arr[i]; //중복 최빈값이 있다면 2번째로 작은 값
                }
            }
            prv = arr[i];
        }

        sb.append(frequent).append('\n'); //최빈값
        sb.append(arr[N - 1] - arr[0]).append('\n'); //범위

        System.out.println(sb);
    }

    static int readInt() throws IOException {
        int n = 0;
        boolean isNegative = false;
        while (true) {
            int input = System.in.read();
            if (input <= 32) {
                return isNegative ? n * -1 : n;
            } else if (input == '-')
                isNegative = true;
            else
                n = (n << 3) + (n << 1) + (input & 15);
        }
    }

}