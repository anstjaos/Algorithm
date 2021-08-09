import java.io.*;
import java.util.Arrays;

public class BOJ_11653 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());
        int temp = N;
        br.close();

        boolean[] isPrime = new boolean[N+5];
        Arrays.fill(isPrime, true);
        for (int i = 2; i < N + 5; i++) {
            if (isPrime[i]) {
                for (int j = i * 2; j < N + 5; j+= i) {
                    isPrime[j] = false;
                }
            }
        }

        int[] count = new int[N+5];
        for (int i = 2; i < N + 5; i++) {
            if (!isPrime[i]) continue;

            while (N % i == 0) {
                N /= i;
                count[i]++;
            }

            if (N == 1) break;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < temp + 5; i++) {
            if (!isPrime[i]) continue;

            while (count[i] > 0) {
                sb.append(i).append("\n");
                count[i]--;
            }
        }

        System.out.print(sb);
    }
}
