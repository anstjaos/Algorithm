import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1987 {
    private static boolean[] visit;
    private static int r, c;
    private static String[] arr;
    private static int result;

    private static int[] dirX = {-1, 0, 1, 0};
    private static int[] dirY = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new String[r];
        visit = new boolean[26];
        for (int i = 0; i < r; i++) arr[i] = br.readLine();
        br.close();

        result = 0;
        dfs(0, 0, 1);

        System.out.println(result);
    }

    private static void dfs(int x, int y, int count) {
        visit[arr[x].charAt(y) - 'A'] = true;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dirX[i];
            int nextY = y + dirY[i];

            if (nextX < 0 || nextY < 0 || nextX >= r || nextY >= c) continue;
            char next = arr[nextX].charAt(nextY);
            if (visit[next - 'A']) continue;
            dfs(nextX, nextY, count+1);
        }

        visit[arr[x].charAt(y) - 'A'] = false;
        result = Math.max(result, count);
    }
}
