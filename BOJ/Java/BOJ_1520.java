import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1520 {
    private static class Point {
        int val, x, y, before;

        public Point(int val, int x, int y, int before) {
            this.val = val;
            this.x = x;
            this.y = y;
            this.before = before;
        }
    }

    private static int[] dirX = {-1, 0, 1, 0};
    private static int[] dirY = {0 , 1, 0 , -1};
    private static int N, M;
    private static int[][] arr;
    private static int[][] visit;

    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visit = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                visit[i][j] = -1;
            }
        }
        br.close();

        System.out.println(dfs(0, 0));
    }

    private static int dfs(int x, int y) {

        if (x == N - 1 && y == M - 1) {
            return 1;
        }
        if (visit[x][y] != -1) {
            return visit[x][y];
        }

        visit[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int nextX = x + dirX[i];
            int nextY = y + dirY[i];

            if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
                continue;
            }

            if (arr[x][y] > arr[nextX][nextY]) {
                visit[x][y] += dfs(nextX, nextY);
            }
        }

        return visit[x][y];
    }
}
