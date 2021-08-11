import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1124 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());
        br.close();

        boolean[] isPrime = new boolean[100006];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i < 100006; i++) {
            if (isPrime[i]) {
                for (int j = i * 2; j < 100006; j += i) isPrime[j] = false;
            }
        }

        int result = 0;
        for (int i = A; i <= B; i++) {
            int count = 0;
            int cur = i;
            int prime = 2;

            while (cur > 1) {
                while (!isPrime[prime] || (cur % prime) != 0) {
                    prime++;
                    if (prime > cur) break;
                }

                cur /= prime;
                count++;
            }

            if (isPrime[count]) result++;
        }

        System.out.println(result);
    }
}
