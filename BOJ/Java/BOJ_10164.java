import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10164 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        int[][] dp = new int[N+5][M+5];
        dp[0][1] = 1;

        if (K != 0) {
            int circleX = K / M + (K % M > 0 ? 1: 0);
            int circleY = K - (circleX - 1) * M;

            for (int i = 1; i <= circleX; i++) {
                for (int j = 1; j <= circleY; j++) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }

            for (int i = K / M + 1; i <= N; i++) {
                for (int j = circleY; j <= M; j++) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        } else {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }

        System.out.println(dp[N][M]);
    }
}
