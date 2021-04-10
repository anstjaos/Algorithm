import java.io.*;

public class BOJ_2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] stair = new int[N+5];
        int[][] dp = new int[N+5][3];

        stair[0] = 0;
        for (int i = 1; i <= N; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }

        dp[1][1] = stair[1];
        dp[2][1] = stair[2];
        dp[2][2] = dp[1][1] +stair[2];

        for (int i = 3; i <= N; i++) {
            dp[i][1] = Math.max(dp[i-2][1], dp[i-2][2]) + stair[i];
            if (dp[i-1][1] != 0) dp[i][2] = dp[i-1][1] + stair[i];
        }

        System.out.println(Math.max(dp[N][1], dp[N][2]));
        br.close();
    }
}
