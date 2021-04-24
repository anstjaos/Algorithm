import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15650 {
    private static boolean[] visit;
    private static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visit = new boolean[N+1];
        StringBuilder sb = new StringBuilder();
        dfs(0, 1, sb);

        System.out.print(sb);
        br.close();
    }

    private static void dfs(int curCount, int curIndex, StringBuilder sb) {
        if (curCount == M) {
            for (int i = 1; i <= N; i++) {
                if (visit[i]) {
                    sb.append(i).append(" ");
                }
            }
            sb.append("\n");
            return;
        }

        for (int i = curIndex; i <= N; i++) {
            if (visit[i]) continue;

            visit[i] = true;
            dfs(curCount + 1, i + 1, sb);
            visit[i] = false;
        }
    }
}
