import java.io.*;

public class BOJ_11057 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[1001][10];
        br.close();

        final int MOD = 10007;

        for (int i = 0; i < 10; i++) dp[1][i] = 1;

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = j; k < 10; k++) {
                    dp[i][j] += dp[i-1][k];
                    dp[i][j] %= MOD;
                }
            }
        }

        int result = 0;
        for (int i = 0; i < 10; i++) {
            result += dp[N][i];
            result %= MOD;
        }

        System.out.println(result);
    }
}
