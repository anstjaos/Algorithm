public class lvl3_49191 {
    public int solution(int n, int[][] results) {
        int[][] floyd = new int[n + 1][n + 1];
        for (int[] result : results) {
            floyd[result[0]][result[1]] = 1;
            floyd[result[1]][result[0]] = -1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if (floyd[i][j] == 1 && floyd[j][k] == 1) {
                        floyd[i][k] = 1;
                        floyd[k][i] = -1;
                    }
                    if (floyd[i][j] == -1 && floyd[j][k] == -1) {
                        floyd[i][k] = -1;
                        floyd[k][i] = 1;
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <= n; j++) {
                if (floyd[i][j] != 0) count++;
            }

            if (count == n - 1) answer++;
        }
        return answer;
    }
}
