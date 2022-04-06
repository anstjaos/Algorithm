import java.io.*;
import java.util.Arrays;

public class BOJ_2153 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        boolean[] isPrime = new boolean[20000];
        Arrays.fill(isPrime, true);
        for (int i = 2; i * i < 20000; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < 20000; j += i) isPrime[j] = false;
            }
        }
        isPrime[0] = false;
        String input = br.readLine();
        br.close();

        int num = 0;
        for (int i = 0; i < input.length(); i++) {
            char cur = input.charAt(i);

            if ('a' <= cur && cur <= 'z') {
                num += (cur - 'a' + 1);
            } else {
                num += (cur - 'A' + 27);
            }
        }

        System.out.println(isPrime[num] ? "It is a prime word." : "It is not a prime word.");
    }
}
