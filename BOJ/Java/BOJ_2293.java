import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2293 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];
        int[] dp = new int[k+5];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            for (int j = arr[i]; j <= k; j++) {
                dp[j] += dp[j - arr[i]];
            }
        }
        br.close();

        System.out.println(dp[k]);
    }
}
