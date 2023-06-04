public class lvl2_12900 {
    public int solution(int n) {
        final int DIV = 1000000007;
        int[] dp = new int[60001];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % DIV;
        }

        return dp[n];
    }
}
