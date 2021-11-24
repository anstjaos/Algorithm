import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17086 {
    private static int x, y;
    private static int[][] map;

    private static int[] dirX = {-1, -1, 0, 1, 1, 1, 0, -1};
    private static int[] dirY = {0, 1, 1, 1, 0, -1, -1, -1};

    private static class Point {
        int x, y, count;

        public Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        map = new int[x][y];
        for (int i = 0; i < x; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < y; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        br.close();

        int result = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (map[i][j] == 1) continue;

                result = Math.max(result, getSafeDistance(new Point(i, j, 0)));
            }
        }

        System.out.println(result);
    }

    private static int getSafeDistance(Point cur) {
        boolean[][] isVisit = new boolean[x][y];
        Queue<Point> queue = new LinkedList<>();
        isVisit[cur.x][cur.y] = true;
        queue.add(cur);

        int result = 0;
        while (!queue.isEmpty()) {
            cur = queue.poll();

            boolean isFind = false;
            for (int i = 0; i < 8; i++) {
                int nextX = cur.x + dirX[i];
                int nextY = cur.y + dirY[i];

                if (nextX < 0 || nextY < 0 || nextX >= x || nextY >= y) continue;
                if (isVisit[nextX][nextY]) continue;

                if (map[nextX][nextY] == 1) {
                    isFind = true;
                    result = cur.count + 1;
                    break;
                }

                isVisit[nextX][nextY] = true;
                queue.add(new Point(nextX, nextY, cur.count + 1));
            }

            if (isFind) break;
        }

        return result;
    }
}
