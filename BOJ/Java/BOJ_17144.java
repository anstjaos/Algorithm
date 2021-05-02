import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17144 {
    private static int r, c;
    private static int[][] room;
    private static int[] dirX = {-1, 0, 1, 0};
    private static int[] dirY = {0, 1, 0, -1};
    private static Point upperAirCleaner, lowerAirCleaner;

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        room = new int[r][c];

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());

                if (room[i][j] == -1) {
                    if (upperAirCleaner == null) {
                        upperAirCleaner = new Point(i, j);
                    } else lowerAirCleaner = new Point(i, j);
                }
            }
        }
        br.close();

        while (t-- > 0) {
            spreadDust();
            cleanDust();
        }

        int result = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (room[i][j] == 0 || room[i][j] == -1) continue;
                result += room[i][j];
            }
        }

        System.out.println(result);
    }

    private static void spreadDust() {
        int[][] temp = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                temp[i][j] = room[i][j];
            }
        }

        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (room[i][j] == 0 || room[i][j] == -1) continue;
                queue.add(new Point(i, j));
            }
        }

        while (!queue.isEmpty()) {
            Point dust = queue.poll();
            int count = 0;
            int spread = temp[dust.x][dust.y] / 5;

            for (int i = 0; i < 4; i++) {
                int nextX = dust.x + dirX[i];
                int nextY = dust.y + dirY[i];

                if (nextX < 0 || nextY < 0 || nextX >= r || nextY >= c) continue;
                if (room[nextX][nextY] == -1) continue;

                count++;
                room[nextX][nextY] += spread;
            }

            room[dust.x][dust.y] -= (spread * count);
        }
    }

    private static void cleanDust() {
        int curX = upperAirCleaner.x;
        int curY = upperAirCleaner.y;
        int dir = 0;

        while (true) {
            int nextX = curX + dirX[dir];
            int nextY = curY + dirY[dir];

            if ((nextX == 0 && nextY == 0) || (nextX == 0 && nextY == c -1) || (nextX == upperAirCleaner.x && nextY == c -1)) {
                dir = (dir + 1) % 4;
            }
            if (nextX == upperAirCleaner.x && nextY == upperAirCleaner.y) break;
            if (!(curX == upperAirCleaner.x && curY == upperAirCleaner.y)) {
                room[curX][curY] = room[nextX][nextY];
            }
            room[nextX][nextY] = 0;
            curX = nextX;
            curY = nextY;
        }

        curX = lowerAirCleaner.x;
        curY = lowerAirCleaner.y;
        dir = 2;

        while (true) {
            int nextX = curX + dirX[dir];
            int nextY = curY + dirY[dir];

            if ((nextX == lowerAirCleaner.x && nextY == c - 1) || (nextX == r -1 && nextY == c -1) || (nextX == r - 1 && nextY == 0)) {
                dir = (dir + 3) % 4;
            }

            if (nextX == lowerAirCleaner.x && nextY == lowerAirCleaner.y) break;
            if (!(curX == lowerAirCleaner.x && curY == lowerAirCleaner.y)) {
                room[curX][curY] = room[nextX][nextY];
            }
            room[nextX][nextY] = 0;
            curX = nextX;
            curY = nextY;
        }
    }
}
