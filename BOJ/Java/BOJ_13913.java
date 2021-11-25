import java.io.*;
import java.util.StringTokenizer;

public class BOJ_13913 {
    private static int[] result, visit;
    private static int N, K, resultCount;

    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        br.close();

        result = new int[300005];
        visit = new int[300005];

        solve(N, 0);
        StringBuilder sb = new StringBuilder();
        sb.append(resultCount).append("\n");
        for (int i = 0; i < resultCount; i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb);
    }

    private static boolean solve(int cur, int count) {
        if (cur == K) {
            result[count] = K;
            resultCount = count;
            return true;
        }

        if (cur * 2 < 300005 && (visit[cur * 2] == 0 || visit[cur * 2] > count + 1)) {
            boolean r = solve(cur * 2, count + 1);
            if (r) {
                result[count] = cur;
                return true;
            }
        }

        if (cur + 1 < K && (visit[cur + 1] == 0 || visit[cur + 1] > count + 1)) {
            boolean r = solve(cur + 1, count + 1);
            if (r) {
                result[count] = cur;
                return true;
            }
        }

        if (cur - 1 >= 0 && (visit[cur - 1] == 0 || visit[cur - 1] > count + 1)) {
            boolean r = solve(cur - 1, count + 1);
            if (r) {
                result[count] = cur;
                return true;
            }
        }

        return false;
    }
}
