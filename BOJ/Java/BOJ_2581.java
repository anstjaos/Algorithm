import java.io.*;
import java.util.Arrays;

public class BOJ_2581 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        boolean[] isPrime = new boolean[10005];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i < 10005; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < 10005; j += i) isPrime[j] = false;
            }
        }

        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        br.close();

        int sum = 0, minPrime = -1;
        for (int i = M; i <= N; i++) {
            if (isPrime[i]) {
                sum += i;
                if (minPrime == -1) minPrime = i;
            }
        }

        if (sum == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(minPrime);
        }
    }
}
