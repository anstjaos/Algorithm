import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3908 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        boolean[] isPrime = new boolean[1300];
        Arrays.fill(isPrime, true);

        for (int i = 2; i * i < 1300; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < 1300; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int[][] dp = new int[1300][20];
        dp[0][0] = 1;

        for (int i = 2; i < 1300; i++) {
            if (isPrime[i]) {
                for (int j = 1299; j >= i; j--) {
                    for (int k = 1; k < 15; k++) {
                        dp[j][k] += dp[j - i][k - 1];
                    }
                }
            }
        }

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
            sb.append(dp[n][k]).append("\n");
        }
        br.close();

        System.out.print(sb);
    }
}
