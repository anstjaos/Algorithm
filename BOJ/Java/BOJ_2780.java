import java.io.*;

public class BOJ_2780 {
    private static final int MOD = 1234567;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[][] dp = new long[1001][10];
        for (int i = 0; i < 10; i++) dp[1][i] = 1;

        for (int i = 2; i < 1001; i++) {
            dp[i][0] = dp[i-1][7] % MOD;
            dp[i][1] = (dp[i-1][2] + dp[i-1][4]) % MOD;
            dp[i][2] = (dp[i-1][1] + dp[i-1][3] + dp[i-1][5]) % MOD;
            dp[i][3] = (dp[i-1][2] + dp[i-1][6]) % MOD;
            dp[i][4] = (dp[i-1][1] + dp[i-1][5] + dp[i-1][7]) % MOD;
            dp[i][5] = (dp[i-1][2] + dp[i-1][4] + dp[i-1][6] + dp[i-1][8]) % MOD;
            dp[i][6] = (dp[i-1][3] + dp[i-1][5] + dp[i-1][9]) % MOD;
            dp[i][7] = (dp[i-1][4] + dp[i-1][0] + dp[i-1][8]) % MOD;
            dp[i][8] = (dp[i-1][5] + dp[i-1][7] + dp[i-1][9]) % MOD;
            dp[i][9] = (dp[i-1][6] + dp[i-1][8]) % MOD;
        }

        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int N = Integer.parseInt(br.readLine());
            long result = 0;
            for (int i = 0; i < 10; i++) {
                result += dp[N][i];
                result %= MOD;
            }

            sb.append(result).append("\n");
        }
        br.close();

        System.out.print(sb);
    }
}
