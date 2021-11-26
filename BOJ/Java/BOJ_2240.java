import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2240 {
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken()), w = Integer.parseInt(st.nextToken());

        int[][] dp = new int[t +1][w+1];
        for (int i = 1; i <= t; i++) {
            int cur = Integer.parseInt(br.readLine());

            for (int j = 0; j <= w; j++) {
                if (j == 0) {
                    if (cur == 1) dp[i][j] = dp[i-1][j] + 1;
                    else dp[i][j] = dp[i-1][j];
                    continue;
                }

                if (j % 2 == 0) {
                    if (cur == 1) dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j] + 1);
                    else dp[i][j] = Math.max(dp[i-1][j-1] + 1, dp[i-1][j]);
                } else {
                    if (cur == 1) dp[i][j] = Math.max(dp[i-1][j-1] + 1, dp[i-1][j]);
                    else dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j] + 1);
                }
            }
        }
        br.close();

        int result = 0;
        for (int i = 0; i <= w; i++) result = Math.max(result, dp[t][i]);

        System.out.println(result);
    }
}
