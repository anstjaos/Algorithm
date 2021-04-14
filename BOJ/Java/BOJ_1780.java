import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1780 {
    private static int[][] arr;
    private static int[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        count = new int[3];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken()) + 1;
            }
        }

        solve(0, 0, N);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append(count[i]).append("\n");
        }

        System.out.print(sb);
        br.close();
    }

    private static void solve(int x, int y, int size) {
        int cur = arr[x][y];

        boolean isAllSame = true;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (cur != arr[x + i][y + j]) {
                    isAllSame = false;
                    break;
                }
            }
            if (!isAllSame) break;
        }

        if (isAllSame) {
            count[cur]++;
            return;
        }

        int nextSize = size / 3;
        solve(x, y, nextSize);
        solve(x, y + nextSize, nextSize);
        solve(x, y + (nextSize * 2), nextSize);

        solve(x + nextSize, y, nextSize);
        solve(x + nextSize, y + nextSize, nextSize);
        solve(x + nextSize, y + (nextSize * 2), nextSize);

        solve(x + (nextSize * 2), y, nextSize);
        solve(x + (nextSize * 2), y + nextSize, nextSize);
        solve(x + (nextSize * 2), y + (nextSize * 2), nextSize);
    }
}
