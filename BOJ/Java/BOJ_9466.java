import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9466 {
    private static boolean[] visit;
    private static boolean[] select;
    private static int count;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            count = 0;
            arr = new int[n+1];
            select = new boolean[n+1];
            visit = new boolean[n+1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) arr[i] = Integer.parseInt(st.nextToken());

            for (int i = 1; i <= n; i++) {
                dfs(i);
            }

            System.out.println(n - count);
        }
        br.close();

        System.out.println(sb);
    }

    private static void dfs(int cur) {
        if (visit[cur]) return;

        visit[cur] = true;
        int next = arr[cur];

        if (!visit[next]) dfs(next);
        else {
            if (!select[next]) {
                count++;
                for (int i = next; i != cur; i = arr[i]) {
                    count++;
                }
            }
        }

        select[cur] = true;
    }
}
