public class lvl2_12913 {
    int solution(int[][] land) {
        int[][] dp = new int[land.length][land[0].length];

        for (int i = 0; i < land[0].length; i++) {
            dp[0][i] = land[0][i];
        }

        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                int maxNum = 0;
                for (int k = 0; k < land[0].length; k++) {
                    if (k == j) continue;
                    maxNum = Math.max(maxNum, dp[i-1][k]);
                }
                dp[i][j] = land[i][j] + maxNum;
            }
        }

        int answer = 0;

        for (int i = 0; i < land[0].length; i++) {
            answer = Math.max(answer, dp[land.length - 1][i]);
        }

        return answer;
    }
}
