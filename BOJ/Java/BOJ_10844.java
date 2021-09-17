import java.io.*;

public class BOJ_10844 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());
        final int MOD = 1000000000;
        br.close();

        long[][] dp = new long[101][10];

        for (int i = 1; i < 10; i++) dp[1][i] = 1;

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) dp[i][j] = dp[i-1][1] % MOD;
                else if (j == 9) dp[i][j] = dp[i-1][8] % MOD;
                else dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % MOD;
            }
        }

        long result = 0;
        for (int i = 0; i < 10; i++) {
            result += dp[N][i];
            result %= MOD;
        }

        System.out.println(result);
    }
}
