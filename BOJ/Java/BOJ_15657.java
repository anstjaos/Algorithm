import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15657 {
    private static int N, M;
    private static int[] arr, visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        visit = new int[N];
        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();

        dfs(0, 0, sb);

        System.out.print(sb);
        br.close();
    }

    private static void dfs(int curCount, int curIndex, StringBuilder sb) {
        if (curCount == M) {
            for (int i = 0; i < N; i++) {
                int num = visit[i];
                if (num == 0) continue;

                while (num-- > 0) {
                    sb.append(arr[i]).append(" ");
                }
            }

            sb.append("\n");
            return;
        }

        for (int i = curIndex; i < N; i++) {
            visit[i]++;
            dfs(curCount + 1, i, sb);
            visit[i]--;
        }
    }
}
