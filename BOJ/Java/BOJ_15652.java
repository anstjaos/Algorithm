import java.io.*;
import java.util.StringTokenizer;

public class BOJ_15652 {
    private static int[] visit;
    private static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visit = new int[N+1];

        StringBuilder sb = new StringBuilder();
        dfs(0, 1, sb);

        System.out.print(sb);
        br.close();
    }

    private static void dfs(int curCount, int curIndex, StringBuilder sb) {
        if (curCount == M) {
            for (int i = 1; i <= N; i++) {
                int num = visit[i];
                if (num == 0) continue;

                while (num-- > 0) {
                    sb.append(i).append(" ");
                }
            }

            sb.append("\n");
            return;
        }

        for (int i = curIndex; i <= N; i++) {
            visit[i]++;
            dfs(curCount + 1, i, sb);
            visit[i]--;
        }
    }
}
