import java.io.*;
import java.util.Arrays;

public class BOJ_4948 {
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        boolean[] isPrime = new boolean[300000];
        isPrime[0] = isPrime[1] = false;
        Arrays.fill(isPrime, true);

        for (int i = 2; i < 300000; i++) {
            if (isPrime[i]) {
                for (int j = i * 2; j < 300000; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            int count = 0;
            for (int i = n + 1; i <= n *2; i++) {
                if (isPrime[i]) count++;
            }

            sb.append(count).append("\n");
        }
        br.close();
        System.out.print(sb);
    }
}
