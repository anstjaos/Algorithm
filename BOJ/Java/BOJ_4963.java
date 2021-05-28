import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4963 {
    private static int[][] map;
    private static boolean[][] visit;
    private static int[] dirX = {-1, -1, 0, 1, 1, 1, 0, -1};
    private static int[] dirY = {0, 1, 1, 1, 0, -1, -1, -1};
    private static int w, h;

    private static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) break;

            map = new int[w][h];
            for (int i = 0; i < w; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < h; j++) map[i][j] = Integer.parseInt(st.nextToken());
            }

            int count = 0;
            visit = new boolean[w][h];
            for (int i = 0; i < w; i++) {
                for (int j = 0; j < h; j++) {
                    if (map[i][j] == 1 && !visit[i][j]) {
                        bfs(new Point(i, j));
                        count++;
                    }
                }
            }

            sb.append(count).append("\n");
        }
        br.close();
        System.out.print(sb);
    }

    private static void bfs(Point start) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            Point cur = queue.poll();

            for (int i = 0; i < 8; i++) {
                int nextX = cur.x + dirX[i];
                int nextY = cur.y + dirY[i];

                if (nextX < 0 || nextY < 0 || nextX >= w || nextY >= h) continue;
                if (map[nextX][nextY] == 0 || visit[nextX][nextY]) continue;

                visit[nextX][nextY] = true;
                queue.add(new Point(nextX, nextY));
            }
        }
    }
}
