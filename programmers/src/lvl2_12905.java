public class lvl2_12905 {
    public int solution(int [][]board)
    {
        int[][] dp = new int[board.length][board[0].length];
        int maxNum = 0;

        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 1) {
                dp[0][i] = 1;
                maxNum = 1;
            }
        }
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 1) {
                dp[i][0] = 1;
                maxNum = 1;
            }
        }

        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[0].length; j++) {
                if (board[i][j] == 0) continue;

                int num = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j -1], dp[i-1][j]));
                dp[i][j] = num + 1;
                maxNum = Math.max(maxNum, dp[i][j]);
            }
        }


        return maxNum * maxNum;
    }
}
