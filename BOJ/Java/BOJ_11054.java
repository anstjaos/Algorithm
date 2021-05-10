import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11054 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        int[] arr = new int[N];
        int[] dp = new int[N];
        int[] reverseDp = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
            for (int j = i - 1 ; j >= 0; j--) {
                if (arr[j] < arr[i]) dp[i] = Math.max(dp[j] + 1, dp[i]);
            }
        }

        for (int i = N - 1; i >= 0; i--) {
            reverseDp[i] = 1;
            for (int j = i + 1; j < N; j++) {
                if (arr[j] < arr[i]) reverseDp[i] = Math.max(reverseDp[j] + 1, reverseDp[i]);
            }
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            result = Math.max(result, dp[i] + reverseDp[i] - 1);
        }

        System.out.println(result);
    }
}
