import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2342 {
    private static final int MAX = 2123456789;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        List<Integer> list = new ArrayList<>();
        while (true) {
            int next = Integer.parseInt(st.nextToken());
            if (next == 0) break;
            list.add(next);
        }

        if (list.size() == 0) {
            System.out.println(0);
            return;
        }

        int[][][] dp = new int[5][5][list.size()];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) Arrays.fill(dp[i][j], MAX);
        }

        dp[list.get(0) - 1][4][0] = 2;
        dp[4][list.get(0) - 1][0] = 2;

        for (int i = 1; i < list.size(); i++) {
            int cur = list.get(i) - 1;

            for (int j = 0; j < 5; j++) {
                dp[cur][j][i] = Math.min(dp[cur][j][i], dp[4][j][i -1] + 2);
                dp[cur][j][i] = Math.min(dp[cur][j][i], Math.min(dp[(cur - 1 + 4) % 4][j][i-1], dp[(cur + 1 + 4) % 4][j][i-1]) + 3);
                dp[cur][j][i] = Math.min(dp[cur][j][i], dp[(cur + 2) % 4][j][i-1] + 4);
                dp[cur][j][i] = Math.min(dp[cur][j][i], dp[cur][j][i-1] + 1);

                dp[j][cur][i] = Math.min(dp[j][cur][i], dp[j][4][i-1] + 2);
                dp[j][cur][i] = Math.min(dp[j][cur][i], Math.min(dp[j][(cur-1+4)%4][i-1], dp[j][(cur+1) %4][i-1]) + 3);
                dp[j][cur][i] = Math.min(dp[j][cur][i], dp[j][(cur+2)%4][i-1] + 4);
                dp[j][cur][i] = Math.min(dp[j][cur][i], dp[j][cur][i-1] + 1);
            }
        }

        int result = MAX;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                result = Math.min(result, dp[i][j][list.size() - 1]);
            }
        }

        System.out.println(result);
    }
}
