import java.io.*;
import java.util.Arrays;

public class BOJ_6588 {
    private static final int SIZE = 1000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] isPrime = new boolean[SIZE];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i < SIZE; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < SIZE; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;

            boolean isFind = false;
            for (int i = 3; i < N; i++) {
                if (!isPrime[i]) continue;

                if (isPrime[N - i]) {
                    sb.append(N).append(" = ").append(i).append(" + ").append(N - i).append("\n");
                    isFind = true;
                    break;
                }
            }

            if (!isFind) sb.append("Goldbach's conjecture is wrong.").append("\n");
        }
        br.close();
        System.out.print(sb);
    }
}
