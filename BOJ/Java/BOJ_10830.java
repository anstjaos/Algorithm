import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10830 {
    private static long[][] matrix;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        matrix = new long[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) matrix[i][j] = Long.parseLong(st.nextToken());
        }

        long[][] result = solve(b);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) sb.append(result[i][j] % 1000).append(" ");
            sb.append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    private static long[][] solve(long b) {
        long[][] result = new long[N][N];
        long[][] temp = new long[N][N];

        if (b == 1) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) result[i][j] = matrix[i][j] % 1000;
            }
            return result;
        }

        if ((b & 1) == 0) {
            temp = solve(b / 2);

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int sum = 0;
                    for (int k = 0; k < N; k++) sum += (temp[i][k] * temp[k][j]);
                    result[i][j] = sum % 1000;
                }
            }
        } else {
            temp = solve(b - 1);

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int sum = 0;
                    for (int k = 0; k < N; k++) sum += (temp[i][k] * matrix[k][j]);
                    result[i][j] = sum % 1000;
                }
            }
        }

        return result;
    }
}
