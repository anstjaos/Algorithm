import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14502 {
    private static int result = 0;
    private static int[] dirX = {-1, 0, 1, 0};
    private static int[] dirY = {0, 1, 0 ,-1};
    private static int[][] lab;
    private static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lab = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        br.close();

        dfs(0, -1, 0);
        System.out.println(result);
    }

    private static void dfs(int x, int y, int count) {
        if (count == 3) {
            result = Math.max(result, bfs());
            return;
        }

        for (int i = y + 1; i < M; i++) {
            if (lab[x][i] == 0) {
                lab[x][i] = 1;
                dfs(x, i, count + 1);
                lab[x][i] = 0;
            }
        }

        for (int i = x + 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (lab[i][j] == 0) {
                    lab[i][j] = 1;
                    dfs(i, j, count + 1);
                    lab[i][j] = 0;
                }
            }
        }
    }

    private static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        int[][] temp = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                temp[i][j] = lab[i][j];
                if (temp[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = cur[0] + dirX[i];
                int nextY = cur[1] + dirY[i];

                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue;
                if (temp[nextX][nextY] != 0) continue;

                temp[nextX][nextY] = 2;
                queue.add(new int[]{nextX, nextY});
            }
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (temp[i][j] == 0) count++;
            }
        }

        return count;
    }
}
