import java.util.Arrays;

public class lvl1_12921 {
    private boolean[] isPrime = new boolean[1000005];

    public int solution(int n) {
        Arrays.fill(isPrime, true);
        for (int i = 2; i * i < 1000005; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < 1000005; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        int answer = 0;

        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) answer++;
        }
        return answer;
    }
}
