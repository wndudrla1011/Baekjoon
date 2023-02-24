package string.p2671;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String sound = br.readLine();
        String pattern = "(100+1+|01)+";

        System.out.println(sound.matches(pattern) ? "SUBMARINE" : "NOISE");
    }

}
