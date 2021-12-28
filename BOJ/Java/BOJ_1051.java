import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1051 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = input.charAt(j) - '0';
            }
        }
        br.close();

        int result = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int maxLength = Math.min(N - i, M - j);
                for (int k = maxLength - 1; k > 0; k--) {
                    if (arr[i][j] == arr[i + k][j] && arr[i][j] == arr[i][j + k] && arr[i][j] == arr[i + k][j + k]) {
                        result = Math.max(result, (k + 1) * (k + 1));
                    }
                }
            }
        }

        System.out.println(result);
    }
}
