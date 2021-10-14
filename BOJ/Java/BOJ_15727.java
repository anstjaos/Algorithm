import java.io.*;

public class BOJ_15727 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int L = Integer.parseInt(br.readLine());
        br.close();

        int[] dp = new int[L+5];
        for (int i = 0; i < L; i++) dp[i] = Integer.MAX_VALUE;

        for (int i = L; i > 0; i--) {
            for (int j = 1; j <= 5; j++) {
                if (i - j >= 0) dp[i - j] = Math.min(dp[i-j], dp[i] + 1);
            }
        }

        System.out.println(dp[0]);
    }
}
