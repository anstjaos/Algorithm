import java.io.*;

public class BOJ_9625 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int K = Integer.parseInt(br.readLine());
        br.close();

        int[][] dp = new int[K + 4][2];
        dp[0][0] = 1;
        dp[0][1] = 0;
        for (int i = 1; i <= K; i++) {
            dp[i][0] = dp[i-1][1];
            dp[i][1] = dp[i-1][0] + dp[i-1][1];
        }

        System.out.println(dp[K][0] + " " + dp[K][1]);
    }
}
