import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[][] sticker = new int[2][N];

            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) sticker[i][j] = Integer.parseInt(st.nextToken());
            }

            sticker[0][1] += sticker[1][0];
            sticker[1][1] += sticker[0][0];

            int result = 0;
            for (int i = 2; i < N; i++) {
                sticker[0][i] += Math.max(sticker[1][i-1], Math.max(sticker[0][i-2], sticker[1][i-2]));
                sticker[1][i] += Math.max(sticker[0][i-1], Math.max(sticker[0][i-2], sticker[1][i-2]));

                result = Math.max(result, Math.max(sticker[0][i], sticker[1][i]));
            }
            sb.append(result).append("\n");
        }

        System.out.print(sb);
        br.close();
    }
}
