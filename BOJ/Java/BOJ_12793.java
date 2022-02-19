import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_12793 {
    private static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int[] dirX = {-1, -1, 1, 1}, dirY = {-1, 1, 1, -1};
    private static int[] qDirX = {-1, 0, 1, 0}, qDirY = {0, 1, 0, -1};
    private static char[][] map;
    private static int M, N;

    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        float K = Float.parseFloat(st.nextToken());

        map = new char[M * 2 + 2][N * 2 + 2];
        Point cur = new Point(M * 2, (int) (K * 2));

        for (int i = 0; i < M * 2 + 1; i++) {
            String input = br.readLine();
            for (int j = 0; j < N * 2 + 1; j++) {
                map[i][j] = input.charAt(j);
            }
        }
        br.close();


        int curDir = (K == 0 ? 1 : 0);

        int count = 0;
        while (true) {
            count += checkBomb(cur, curDir);
            cur.x = cur.x + dirX[curDir];
            cur.y = cur.y + dirY[curDir];
            if (cur.x == M * 2) break;

            if (cur.x == 0) {
                if (cur.y == 0) curDir = 2;
                else if (cur.y == 2 * N) curDir = 3;
                else curDir = changeDirection(0, curDir);
            }
            else if (cur.y == 0) curDir = changeDirection(1, curDir);
            else if (cur.y == 2 * N) {
                curDir = changeDirection(2, curDir);
            }
        }
        System.out.println(count);
    }

    private static int checkBomb(Point point, int dir) {
        int nextX = point.x + dirX[dir];
        int nextY = point.y + dirY[dir];

        int result = 0;
        if (map[nextX][point.y] == 'B' || map[nextX][point.y] == '.') {
            changeBlock(nextX, point.y);
            result++;
        }
        if (map[point.x][nextY] == 'B' || map[point.x][nextY] == '.') {
            changeBlock(point.x, nextY);
            result++;
        }
        if (map[nextX][nextY] == 'B' || map[nextX][nextY] == '.') {
            changeBlock(nextX, nextY);
            result++;
        }

        return result;
    }

    private static void changeBlock(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));

        if (map[x][y] == 'B') map[x][y] = 'O';
        if (map[x][y] == '.') {
            if (x % 2 == 0) map[x][y] = '-';
            else map[x][y] = '|';
        }

        while (!queue.isEmpty()) {
            Point curPoint = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = curPoint.x + qDirX[i], nextY = curPoint.y + qDirY[i];

                if (nextX < 0 || nextY < 0 || nextX > M * 2 || nextY > N * 2) continue;

                if (map[nextX][nextY] == 'B') {
                    map[nextX][nextY] = 'O';
                    queue.add(new Point(nextX, nextY));
                }
                else if (map[nextX][nextY] == '.') {
                    queue.add(new Point(nextX, nextY));
                    if (x % 2 == 0) map[nextX][nextY] = '-';
                    else map[nextX][nextY] = '|';
                }
            }
        }
    }

    private static int changeDirection(int num, int dir) {
        if (num == 0) {
            switch (dir) {
                case 0:
                    dir = 3;
                    break;
                case 1:
                    dir = 2;
                    break;
                default:
                    break;
            }
        } else if (num == 1) {
            switch (dir) {
                case 0:
                    dir = 1;
                    break;
                case 3:
                    dir = 2;
                    break;
                default:
                    break;
            }
        } else if (num == 2) {
            switch (dir) {
                case 1:
                    dir = 0;
                    break;
                case 2:
                    dir = 3;
                    break;
                default:
                    break;
            }
        }
        return dir;
    }
}
