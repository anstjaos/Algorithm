public class lvl2_12978 {
    public int solution(int N, int[][] road, int K) {
        int[][] dist = new int[N + 1][N + 1];

        final int MAX_VAL = 5000001;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) continue;
                dist[i][j] = MAX_VAL;
            }
        }

        for (int[] r : road) {
            if (dist[r[0]][r[1]] > r[2]) {
                dist[r[0]][r[1]] = r[2];
                dist[r[1]][r[0]] = r[2];
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    if (dist[j][k] > dist[j][i] + dist[i][k]) {
                        dist[j][k] = dist[j][i] + dist[i][k];
                    }
                }
            }
        }
        int answer = 1;
        for (int i = 2; i <= N; i++) {
            if (dist[1][i] <= K) answer++;
        }

        return answer;
    }
}
