import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11404 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()), M = Integer.parseInt(br.readLine());
        int[][] costs = new int[N+1][N+1];
        for (int i = 1 ;i <= N; i++) Arrays.fill(costs[i], Integer.MAX_VALUE);
        StringTokenizer st;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()), to = Integer.parseInt(st.nextToken()), cost = Integer.parseInt(st.nextToken());

            costs[from][to] = Integer.min(costs[from][to], cost);
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (costs[i][k] == Integer.MAX_VALUE || costs[k][j] == Integer.MAX_VALUE) continue;
                    if (costs[i][j] > costs[i][k] + costs[k][j]) {
                        costs[i][j] = costs[i][k] + costs[k][j];
                    }
                }
            }
        }

        br.close();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (costs[i][j] == Integer.MAX_VALUE || i == j) sb.append(0).append(" ");
                else sb.append(costs[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
