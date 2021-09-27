import java.io.*;

public class BOJ_2156 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+5];
        int[] wine = new int[N+5];
        for (int i = 0; i < N; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        if (N >= 1) {
            dp[0] = wine[0];
        }

        if (N >= 2) {
            dp[1] = wine[0] + wine[1];
        }

        if (N >= 3) {
            dp[2] = Math.max(dp[1], Math.max(dp[0] + wine[2], wine[1] + wine[2]));
        }
        for (int i = 3; i < N; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + wine[i], dp[i - 3] + wine[i - 1] + wine[i]));
        }
        System.out.println(dp[N - 1]);

    }
}
