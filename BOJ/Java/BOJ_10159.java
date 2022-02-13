import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10159 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        boolean[][] known = new boolean[N+1][N+1];
        boolean[][] reverseKnown = new boolean[N+1][N+1];

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            known[a][b] = true;
            reverseKnown[b][a] = true;
        }
        br.close();

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (known[i][k] && known[k][j]) {
                        known[i][j] = true;
                    }

                    if (reverseKnown[i][k] && reverseKnown[k][j]) {
                        reverseKnown[i][j] = true;
                    }
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                known[i][j] |= reverseKnown[i][j];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            int count = 0;
            for (int j = 1; j <= N; j++) {
                if (i == j) continue;

                if (!known[i][j]) count++;
            }
            sb.append(count).append("\n");
        }

        System.out.print(sb);
    }
}
