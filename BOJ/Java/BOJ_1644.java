import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1644 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();

        boolean[] isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true);
        int[] primeArr = new int[N / 2 + 1];
        int count = 0;

        for (int i = 2; i * i <= N; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        for (int i = 2; i <= N; i++) {
            if (isPrime[i]) primeArr[count++] = i;
        }

        int left = 0, right = 0, sum = 0;
        int result = 0;
        while (left <= right && right <= count) {
            if (sum <= N) {
                if (sum == N) result++;
                if (right == count) break;
                sum += primeArr[right++];
            } else if (sum > N) {
                sum -= primeArr[left++];
            }
        }

        System.out.println(result);
    }
}
