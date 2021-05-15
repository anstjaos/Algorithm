import java.io.*;
import java.util.StringTokenizer;

public class BOJ_17404 {
    private static final int MAX_INT = 2123456789;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }
        br.close();

        int result = MAX_INT;
        for (int k = 0; k < 3; k++) {
            int[][] dp = new int[N][3];
            for (int i = 0; i < 3; i++) {
                if (i == k) dp[0][i] = arr[0][i];
                else dp[0][i] = MAX_INT;
            }

            for (int i = 1; i < N; i++) {
                dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + arr[i][0];
                dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + arr[i][1];
                dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + arr[i][2];
            }

            for (int i = 0; i < 3; i++) {
                if (i != k) result = Math.min(result, dp[N-1][i]);
            }
        }

        System.out.println(result);
    }
}
