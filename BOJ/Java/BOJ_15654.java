import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15654 {
    private static int N, M;
    private static int[] arr, order;
    private static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        visit = new boolean[N];

        StringBuilder sb = new StringBuilder();
        order = new int[M];
        dfs(0, sb);

        System.out.print(sb);
        br.close();
    }

    private static void dfs(int curCount, StringBuilder sb) {
        if (curCount == M) {
            for (int i = 0; i < M; i++) {
                sb.append(order[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visit[i]) continue;

            visit[i] = true;
            order[curCount] = arr[i];
            dfs(curCount + 1, sb);
            visit[i] = false;
        }
    }
}
