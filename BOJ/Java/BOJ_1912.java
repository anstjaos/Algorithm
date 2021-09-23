import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1912 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            result = Math.max(result, arr[i]);
        }
        br.close();

        dp[0] = arr[0];

        for (int i = 1; i < n; i++) {
           dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
           result = Math.max(result, dp[i]);
        }

        System.out.println(result);
    }
}
