import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2630 {
    private static int whiteCount = 0;
    private static int blueCount = 0;
    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(0, 0, N);
        System.out.println(whiteCount + "\n" + blueCount);
        br.close();
    }

    private static void solve(int curX, int curY, int size) {
        int cur = arr[curX][curY];

        boolean allSame = true;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (arr[curX + i][curY + j] != cur) {
                    allSame = false;
                    break;
                }
            }
            if (!allSame) break;
        }

        if (allSame) {
            if (cur == 0) whiteCount++;
            else blueCount++;

            return;
        }

        solve(curX, curY, size/2);
        solve(curX + (size/2), curY, size/2);
        solve(curX, curY + (size/2), size/2);
        solve(curX + (size/2), curY + (size/2), size/2);
    }
}
