import java.io.*;

public class BOJ_9252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine(), B = br.readLine();
        int aLength = A.length(), bLength = B.length();
        br.close();

        int[][] dp = new int[aLength + 1][bLength + 1];

        int max = 0;
        for (int i = 0; i < aLength; i++) {
            char a = A.charAt(i);
            for (int j = 0; j < bLength; j++) {
                char b = B.charAt(j);

                dp[i+1][j+1] = (a == b ? dp[i][j] + 1 : Math.max(dp[i][j + 1], dp[i + 1][j]));
                max = Math.max(max, dp[i+1][j+1]);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = aLength; i > 0; i--) {
            char a = A.charAt(i-1);
            for (int j = bLength; j > 0; j--) {
                char b = B.charAt(j-1);

                if (dp[i][j] == max && a == b) {
                    sb.append(a);
                    max -= 1;
                    break;
                }
            }
        }

        System.out.println(sb.length());
        System.out.println(sb.reverse());
    }
}
