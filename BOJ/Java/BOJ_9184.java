import java.io.*;
import java.util.StringTokenizer;

public class BOJ_9184 {
    private static int[][][] memo;

    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        memo = new int[105][105][105];

        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1 && c == -1) break;
            int result = solve(a + 50, b + 50, c + 50);
            sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ").append(result).append("\n");
        }

        br.close();
        System.out.print(sb);
    }

    private static int solve(int a, int b, int c) {
        if (memo[a][b][c] != 0) return memo[a][b][c];

        if (a <= 50 || b <= 50 || c <= 50) {
            memo[a][b][c] = 1;
            return memo[a][b][c];
        }

        if (a > 70 || b > 70 || c > 70) {
            memo[a][b][c] = solve(70, 70, 70);
            return memo[a][b][c];
        }

        if (a < b && b < c) {
            memo[a][b][c] = solve(a, b, c - 1) + solve(a, b - 1, c -1) - solve(a, b - 1, c);
            return memo[a][b][c];
        }

        memo[a][b][c] = solve(a - 1, b, c) + solve(a - 1, b - 1, c) + solve(a - 1, b, c - 1) - solve(a - 1, b - 1, c - 1);
        return memo[a][b][c];
    }
}
