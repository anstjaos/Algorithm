import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] sum = new int[N+5][N+5];

        int num;
        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i; j++) {
                num = Integer.parseInt(st.nextToken());
                sum[i][j] = Math.max(sum[i-1][j-1] + num, sum[i-1][j] + num);
            }
        }

        int result = 0;
        for (int i = 1; i <= N; i++) {
            result = Math.max(result, sum[N][i]);
        }

        System.out.println(result);
    }
}
