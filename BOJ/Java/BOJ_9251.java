import java.io.*;

public class BOJ_9251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input1 = br.readLine(), input2 = br.readLine();
        br.close();

        int length1 = input1.length(), length2 = input2.length();
        int[][] dp = new int[length1 + 1][length2 + 1];

        int result = 0;
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (input1.charAt(i - 1) == input2.charAt(j - 1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
                result = Math.max(result, dp[i][j]);
            }
        }

        System.out.println(result);
    }
}
