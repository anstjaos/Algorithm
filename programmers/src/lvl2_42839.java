import java.util.*;

public class lvl2_42839 {
    private boolean[] isPrime = new boolean[10000000];
    private boolean[] isVisit = new boolean[10000000];
    private boolean[] isUsed;
    private int answer;

    public int solution(String numbers) {
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i < 10000000; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < 10000000; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        isUsed = new boolean[numbers.length()];

        dfs(0, numbers, "");

        return answer;
    }

    private void dfs(int depth, String numbers, String result) {
        if (depth > 0) {
            int num = Integer.parseInt(result);
            if (!isVisit[num] && isPrime[num]) {
                answer++;
            }
            isVisit[num] = true;
        }

        if (depth == numbers.length()) return;

        for (int i = 0; i < numbers.length(); i++) {
            if (isUsed[i]) continue;

            isUsed[i] = true;
            dfs(depth + 1, numbers, result + numbers.charAt(i));
            isUsed[i] = false;
        }
    }
}
