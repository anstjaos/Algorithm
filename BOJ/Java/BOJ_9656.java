import java.io.*;

public class BOJ_9656 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());
        br.close();

        int[] dp = new int[N+1];
        dp[N] = 1;
        // 1 : 상근, 2 : 창영
        for (int i = N; i >= 0; i--) {
            if (dp[i] == 0) continue;

            int next = (dp[i] == 1 ? 2 : 1);
            if (i - 1 >= 0) dp[i-1] = next;
            if (i - 3 >= 0) dp[i - 3] = next;
        }

        System.out.println(dp[0] == 1 ? "SK" : "CY");
    }
}
