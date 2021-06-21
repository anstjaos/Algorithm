import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2740 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int[][] arrA = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arrA[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] arrB = new int[M][K];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < K; j++) {
                arrB[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        int[][] result = new int[N][K];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < K; j++) {
                int sum = 0;
                for (int k = 0; k < M; k++) {
                    sum += (arrA[i][k] * arrB[k][j]);
                }
                result[i][j] = sum;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < K; j++) sb.append(result[i][j]).append(" ");
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
