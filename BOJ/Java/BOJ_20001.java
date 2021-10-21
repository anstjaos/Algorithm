import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_20001 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        int problemCount = 0;
        while (true) {
            String input = br.readLine();

            if (input.length() == 11) continue;
            if (input.length() == 10) break;

            if (input.length() == 2) problemCount++;
            if (input.length() == 4) {
                if (problemCount == 0) problemCount += 2;
                else problemCount--;
            }
        }
        br.close();

        if (problemCount == 0) System.out.println("고무오리야 사랑해");
        else System.out.println("힝구");
    }
}
