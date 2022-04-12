import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2665 {
    private static int n;
    private static int[][] map, dist;
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
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = input.charAt(j) - '0';
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        br.close();

        bfs();

        System.out.println(dist[n-1][n-1]);
    }

    private static void bfs() {
        Queue<Point> queue = new LinkedList<>();
        dist[0][0] = 0;
        queue.add(new Point(0, 0));

        while (!queue.isEmpty()) {
            Point cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = cur.x + dirX[i], nextY = cur.y + dirY[i];

                if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= n) continue;
                if (dist[nextX][nextY] > dist[cur.x][cur.y]) {
                    if (map[nextX][nextY] == 1) dist[nextX][nextY] = dist[cur.x][cur.y];
                    else dist[nextX][nextY] = dist[cur.x][cur.y] + 1;

                    queue.add(new Point(nextX, nextY));
                }
            }
        }
    }
}
