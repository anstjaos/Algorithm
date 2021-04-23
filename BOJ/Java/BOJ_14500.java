import java.io.*;
import java.util.StringTokenizer;

public class BOJ_14500 {
    private static int[][] dirX = {{0, 0, 0, 0}, {0, 1, 2, 3}, {0, 0, 1, 1}, {0, 1, 2, 2}, {0, 1, 2, 2}, {0, 0, 1, 2}, {0, 0, 1, 2},
            {0, 0, 0, -1}, {0, 1, 1, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 1, 1, 2}, {0, 1, 1, 2}, {0, 0, -1, -1}, {0, 0, 1, 1},
            {0, 0, 0, 1}, {0, 0, -1, 0}, {0, 1, 1, 2}, {0, 1, 1, 2}};

    private static int[][] dirY = {{0, 1, 2, 3}, {0, 0, 0, 0}, {0, 1, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, -1}, {0, 1, 1, 1}, {0, 1, 0, 0},
            {0, 1, 2, 2}, {0, 0, 1, 2}, {0, 1, 2, 0}, {0, 1, 2, 2}, {0, 0, 1, 1}, {0, 0, -1, -1}, {0, 1, 1, 2}, {0, 1, 1, 2},
            {0, 1, 2, 1}, {0, 1, 1, 2}, {0, 0, -1, 0}, {0, 0, 1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < 19; k++) {
                    int sum = 0;
                    for (int l = 0; l < 4; l++) {
                        int nextX = i + dirX[k][l];
                        int nextY = j + dirY[k][l];

                        if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) {
                            sum = -1;
                            break;
                        }
                        sum += arr[nextX][nextY];
                    }
                    result = Math.max(result, sum);
                }
            }
        }

        System.out.println(result);
        br.close();
    }
}
