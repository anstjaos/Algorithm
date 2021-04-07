import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_18111 {
    private static int N;
    private static int M;
    private static int[][] ground;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        ground = new int[N + 1][M + 1];
        int min = Integer.MAX_VALUE, max = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                ground[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(ground[i][j], min);
                max = Math.max(ground[i][j], max);
            }
        }
        br.close();

        int minTime = Integer.MAX_VALUE;
        int maxHeight = 0;

        for (int i = min; i <= max; i++) {
            int result = getWorkTime(i, B);
            if (result == -1) continue;

            if (result == minTime) {
                maxHeight = Math.max(maxHeight, i);
            } else if (result < minTime) {
                minTime = result;
                maxHeight = i;
            }
        }

        System.out.println(minTime + " " + maxHeight);
    }

    private static int getWorkTime(int height, int blockCount) {
        int result = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (ground[i][j] == height) continue;

                int difference = Math.abs(ground[i][j] - height);
                if (ground[i][j] > height) {
                    blockCount += difference;
                    result += (2 * difference);
                } else {
                    blockCount -= difference;
                    result += difference;
                }
            }
        }

        if (blockCount < 0) return -1;

        return result;
    }
}
