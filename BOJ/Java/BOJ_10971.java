import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10971 {
    private static int result, N;
    private static int[][] arr;
    private static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visit = new boolean[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }
        br.close();
        result = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            solve(i, i, 0, 0);
        }

        System.out.println(result);
    }

    private static void solve(int start, int cur, int count, int sum) {
        if (count == N - 1) {
            if (arr[cur][start] == 0) return;
            result = Math.min(result, sum + arr[cur][start]);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (i == start || visit[i] || arr[cur][i] == 0) continue;

            visit[i] = true;
            solve(start, i, count + 1, sum + arr[cur][i]);
            visit[i] = false;
        }
    }
}
