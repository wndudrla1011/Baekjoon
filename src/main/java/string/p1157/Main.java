package string.p1157;

public class Main {

    public void solution() throws Exception {
        int[] check = new int[26];

        char c;
        while ((c = (char) System.in.read()) > 32) {
            if (c >= 'A' && c <= 'Z')
                check[c - 65]++;
            else check[c - 97]++;
        }

        int max = Integer.MIN_VALUE, key = 0, maxIdx = 0;
        for (int i = 0; i < check.length; i++) {
            if (max < check[i]) {
                max = check[i];
                maxIdx = i;
            }
            else if (max == check[i]) key = check[i];
        }

        if (max == key) System.out.println("?");
        else System.out.println((char) (maxIdx + 65));
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

}
