import java.io.*;
import java.util.StringTokenizer;

public class BOJ_16194 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] card = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) card[i] = Integer.parseInt(st.nextToken());
        br.close();

        int[] dp = new int[N+1];
        for (int i = 1; i <= N; i++) dp[i] = card[i];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                for (int k = 1; i - j * k > 0; k++) {
                    dp[i] = Math.min(dp[i], dp[i - j *k] + dp[j] * k);
                }
            }
        }

        System.out.println(dp[N]);
    }
}
