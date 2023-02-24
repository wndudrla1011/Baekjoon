package string.p13022;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String wolf = br.readLine();
        String valid = "(w+o+l+f+)+";
        int wCount = 0, oCount = 0, lCount = 0, fCount = 0;
        boolean check = true;

        for (int i = 0; i < wolf.length(); i++) {
            if (wolf.charAt(i) == 'w')
                wCount++;
            else if (wolf.charAt(i) == 'o')
                oCount++;
            else if (wolf.charAt(i) == 'l')
                lCount++;
            else if (wolf.charAt(i) == 'f')
                fCount++;
            if (i < wolf.length() - 1 && wolf.charAt(i) == 'f' && wolf.charAt(i + 1) == 'w') {
                if (!(wCount == oCount && oCount == lCount && lCount == fCount)) {
                    check = false;
                    break;
                }
            }
        }

        if (check && wolf.matches(valid) && wCount == oCount && oCount == lCount && lCount == fCount)
            System.out.println(1);
        else
            System.out.println(0);
    }

}
