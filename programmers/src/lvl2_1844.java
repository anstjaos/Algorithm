import java.util.*;

public class lvl2_1844 {
    class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private int[] dirX = {-1, 0, 1, 0};
    private int[] dirY = {0, 1, 0, -1};
    private int[][] visit;

    public int solution(int[][] maps) {
        int x = maps.length, y = maps[0].length;

        visit = new int[x][y];
        for (int i = 0; i < x; i++) {
            Arrays.fill(visit[i], -1);
        }

        visit[0][0] = 0;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0));

        int answer = -1;

        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            if (cur.x == x - 1 && cur.y == y - 1) {
                answer = visit[cur.x][cur.y] + 1;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = cur.x + dirX[i];
                int nextY = cur.y + dirY[i];

                if (nextX < 0 || nextY < 0 || nextX >= x || nextY >= y) continue;
                if (visit[nextX][nextY] != -1 || maps[nextX][nextY] == 0) continue;

                visit[nextX][nextY] = visit[cur.x][cur.y] + 1;
                queue.add(new Point(nextX, nextY));
            }
        }
        return answer;
    }
}
