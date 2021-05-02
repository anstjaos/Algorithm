import java.io.*;
import java.util.StringTokenizer;

public class BOJ_17070 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] house = new int[N+1][N+1];
        int[][][] dp = new int[N+1][N+1][3];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                house[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        dp[1][2][0] = 1;

        for (int i = 3; i <= N; i++) {
            if (house[1][i] == 1) break;

            dp[1][i][0] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 2; j <= N; j++) {
                if (house[i][j] == 1) continue;

                dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][2];
                dp[i][j][1] = dp[i-1][j][1] + dp[i-1][j][2];

                if (house[i][j - 1] == 0 && house[i - 1][j] == 0 && house[i - 1][j - 1] == 0) {
                    dp[i][j][2] = dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];
                }
            }
        }

        System.out.println(dp[N][N][0] + dp[N][N][1] + dp[N][N][2]);
    }
}
