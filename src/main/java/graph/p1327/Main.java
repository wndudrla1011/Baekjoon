package graph.p1327;

import java.io.*;
import java.util.*;

public class Main {

    static int N, K;
    static char[] A, copy;
    static String A_str, copy_str;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new char[N]; //오름차순 배열
        A = br.readLine().replace(" ", "").toCharArray();

        copy = Arrays.copyOf(A, N); //원본 배열
        Arrays.sort(A);
        A_str = new String(A);
        copy_str = new String(copy);

        System.out.println(BFS());
    }

    static int BFS() {
        Queue<Data> q = new LinkedList<>();
        Set<String> search = new HashSet<>(); //방문 체크 (중복을 제외한 모든 경우의 수)
        q.offer(new Data(copy_str, 0));

        while (!q.isEmpty()) {
            Data d = q.poll();
            String str = d.str;
            int cnt = d.cnt;

            //결과와 같을 경우 cnt 반환
            if (A_str.equals(str)) return cnt;

            //Set에 포함되어 있지 않을 경우 K개 뒤집은 배열 넣기
            if (!search.contains(str)) {
                search.add(str);
                /*
                * N에서 K만큼 떨어진 위치까지 reverse 가능
                * i ~ (i + K - 1) 인덱스(reverse 범위)
                * cnt : 트리의 높이 역할
                * */
                for (int i = 0; i <= N - K; i++) {
                    q.offer(new Data(reverseStr(str, i, i + K), cnt + 1));
                }
            }
        }
        return -1;
    }

    static String reverseStr(String str, int i, int j) {
        StringBuilder sb = new StringBuilder();
        sb.append(str, 0, i); //앞부분 그대로 가져오기

        //특정 부분만 뒤집기
        String reverse = str.substring(i, j);
        for (int t = K - 1; t >= 0; t--) { //K개 만큼 뒤집기
            sb.append(reverse.charAt(t));
        }

        sb.append(str, j, N); //뒷부분 그대로 가져오기
        return sb.toString();
    }

    static class Data {
        String str; //현재 수열
        int cnt; //선택 횟수

        public Data(String str, int cnt) {
            this.str = str;
            this.cnt = cnt;
        }
    }

}
