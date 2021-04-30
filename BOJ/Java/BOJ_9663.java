import java.io.*;

public class BOJ_9663 {
    private static int[] queen;
    private static int result = 0;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         N = Integer.parseInt(br.readLine());

        queen = new int[N];

        dfs(0);

        System.out.println(result);

        br.close();
    }

    private static void dfs(int x) {
        if (x == N) {
            result++;
            return;
        }

        for (int i = 0; i < N; i++) {
            queen[x] = i;

            if (isPossible(x)) {
                dfs(x+1);
            }
        }
    }

    private static boolean isPossible(int col) {

        for (int i = 0; i < col; i++) {
            if (queen[col] == queen[i]) {
                return false;
            } else if (Math.abs(col - i) == Math.abs(queen[col] - queen[i])) {
                return false;
            }
        }

        return true;
    }
}
