import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1743 {
    private static int N, M;
    private static char[][] map;
    private static boolean[][] visit;
    private static int[] dirX = {-1, 0, 1, 0}, dirY = {0, 1, 0, -1};

    private static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        map = new char[N+1][M+1];
        visit = new boolean[N+1][M+1];

        for (int i = 0; i < N + 1; i++) {
            Arrays.fill(visit[i], false);
            Arrays.fill(map[i], '.');
        }
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = '#';
        }
        br.close();

        int result = 0;
        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < M + 1; j++) {
                if (map[i][j] == '#' && !visit[i][j]) {
                    result = Math.max(result, bfs(i, j));
                }
            }
        }
        System.out.println(result);
    }

    private static int bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        visit[x][y] = true;

        int result = 0;
        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            result++;

            for (int i = 0; i < 4; i++) {
                int nextX = cur.x + dirX[i];
                int nextY = cur.y + dirY[i];

                if (nextX < 0 || nextY < 0 || nextX >= (N + 1) || nextY >= (M + 1)) continue;
                if (visit[nextX][nextY] || map[nextX][nextY] == '.') continue;

                visit[nextX][nextY] = true;
                queue.add(new Point(nextX, nextY));
            }
        }

        return result;
    }
}
