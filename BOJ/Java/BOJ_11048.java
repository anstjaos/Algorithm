import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11048 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        int[][] candy = new int[N][M];
        int[][][] dp = new int[N][M][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) candy[i][j] = Integer.parseInt(st.nextToken());
        }
        br.close();
        dp[0][0][0] = dp[0][0][1] = dp[0][0][2] = candy[0][0];

        int[] dirX = {0, 1, 1}, dirY = {1, 0, 1};

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i == N -1 && j == M - 1) continue;

                int cur = Math.max(dp[i][j][0], Math.max(dp[i][j][1], dp[i][j][2]));
                for (int k = 0; k < 3; k++) {
                    int nextX = i + dirX[k], nextY = j + dirY[k];

                    if (nextX >= N || nextY >= M) continue;

                    dp[nextX][nextY][k] = candy[nextX][nextY] + cur;
                }
            }
        }

        System.out.println(Math.max(dp[N-1][M-1][0], Math.max(dp[N-1][M-1][1], dp[N-1][M-1][2])));
    }
}
