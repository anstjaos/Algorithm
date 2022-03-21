import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1915 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        if (N == 1 && M == 1) {
            System.out.println(1);
            return;
        }


        int[][] dp = new int[N+1][M+1];
        int result = 0;
        for (int i = 1; i <= N; i++) {
            String input = br.readLine();
            for (int j = 1; j <= M; j++) {
                int num = input.charAt(j - 1) - '0';
                if (i == 1 && j == 1) {
                    dp[i][j] = num;
                    continue;
                }

                if (num == 1) {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                    result = Math.max(result, dp[i][j]);
                }
            }
        }

        br.close();
        System.out.println(result * result);
    }
}
