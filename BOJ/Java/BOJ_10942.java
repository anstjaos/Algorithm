import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10942 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N+1];
        for (int i = 1; i <= N; i++) arr[i] = Integer.parseInt(st.nextToken());

        boolean[][] dp = new boolean[N+1][N+1];
        for(int i = 1; i <= N; i++) dp[i][i] = true;

        for(int i = 1; i <= N - 1; i++) if(arr[i] == arr[i + 1]) dp[i][i + 1]= true;

        for(int i = 2; i < N; i++){
            for(int j = 1; j <= N - i; j++){
                if(arr[j] == arr[j + i] && dp[j + 1][j + i - 1])
                    dp[j][j + i] = true;
            }
        }

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            sb.append(dp[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] ? 1 : 0).append("\n");
        }
        br.close();

        System.out.print(sb);
    }
}
