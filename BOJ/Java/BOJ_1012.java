import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1012 {

    private static int[] dirX = {-1, 0, 1, 0};
    private static int[] dirY = {0, 1, 0, -1};

    private static int M;
    private static int N;
    private static int[][] ground;
    private static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            ground = new int[N][M];
            visit = new boolean[N][M];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken()), x = Integer.parseInt(st.nextToken());

                ground[x][y] = 1;
            }

            int result = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (ground[i][j] == 1 && !visit[i][j]) {
                        result++;
                        search(i, j);
                    }
                }
            }

            sb.append(result).append("\n");
        }

        System.out.print(sb);
        br.close();
    }

    private static void search(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});

        while (!queue.isEmpty()) {
            int[] curPoint = queue.poll();
            visit[curPoint[0]][curPoint[1]] = true;

            for (int i = 0; i < 4; i++) {
                int nextX = curPoint[0] + dirX[i];
                int nextY = curPoint[1] + dirY[i];

                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue;
                if (!visit[nextX][nextY] && ground[nextX][nextY] == 1) {
                    queue.add(new int[] {nextX, nextY});
                    visit[nextX][nextY] = true;
                }
            }
        }
    }
}
