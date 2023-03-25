package stack.p17298;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = readInt();
        int[] A = new int[N]; //입력 배열
        int[] result = new int[N]; //결과 배열

        for (int i = 0; i < N; i++) A[i] = readInt();

        Stack<Integer> stack = new Stack<>(); //index 저장
        stack.push(0);

        for (int i = 0; i < N; i++) {
            //stack이 비어 있지 않고, 현재 값이 stack 최상단 값보다 크면
            while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
                result[stack.pop()] = A[i]; //정답 배열에 오큰수 저장
            }
            stack.push(i); //신규 데이터 저장
        }

        /*
        * 데이터가 여전히 남았다면, 오큰수가 없었다는 것
        * */
        while (!stack.isEmpty()) result[stack.pop()] = -1;

        for (int i = 0; i < N; i++) {
            bw.write(result[i] + " ");
        }

        bw.flush();
        bw.close();
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
