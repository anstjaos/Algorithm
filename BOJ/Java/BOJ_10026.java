import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_10026 {
    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int[] dirX = { -1, 0, 1, 0 };
    private static int[] dirY = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] input = new char[N][N];

        for (int i = 0; i < N; i++) {
            input[i] = br.readLine().toCharArray();
        }

        StringBuilder sb = new StringBuilder();
        boolean[][] visit = new boolean[N][N];
        Queue<Point> queue = new LinkedList<>();

        int red = 0, blue = 0, green = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visit[i][j]) continue;

                switch (input[i][j]) {
                    case 'R':
                        queue.clear();
                        queue.add(new Point(i, j));
                        visit[i][j] = true;
                        red++;

                        while (!queue.isEmpty()) {
                            Point cur = queue.poll();

                            for (int n = 0; n < 4; n++) {
                                int nextX = cur.x + dirX[n];
                                int nextY = cur.y + dirY[n];

                                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) continue;
                                if (visit[nextX][nextY] || input[nextX][nextY] != 'R') continue;

                                visit[nextX][nextY] = true;
                                queue.add(new Point(nextX, nextY));
                            }
                        }
                        break;
                    case 'G':
                        queue.clear();
                        queue.add(new Point(i, j));
                        visit[i][j] = true;
                        green++;

                        while (!queue.isEmpty()) {
                            Point cur = queue.poll();

                            for (int n = 0; n < 4; n++) {
                                int nextX = cur.x + dirX[n];
                                int nextY = cur.y + dirY[n];

                                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) continue;
                                if (visit[nextX][nextY] || input[nextX][nextY] != 'G') continue;

                                visit[nextX][nextY] = true;
                                queue.add(new Point(nextX, nextY));
                            }
                        }
                        break;
                    case 'B':
                        queue.clear();
                        queue.add(new Point(i, j));
                        visit[i][j] = true;
                        blue++;

                        while (!queue.isEmpty()) {
                            Point cur = queue.poll();

                            for (int n = 0; n < 4; n++) {
                                int nextX = cur.x + dirX[n];
                                int nextY = cur.y + dirY[n];

                                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) continue;
                                if (visit[nextX][nextY] || input[nextX][nextY] != 'B') continue;

                                visit[nextX][nextY] = true;
                                queue.add(new Point(nextX, nextY));
                            }
                        }
                        break;
                }
            }
        }

        sb.append(red + green + blue).append(" ");

        red = blue = green = 0;
        for (int i = 0; i < N; i++) Arrays.fill(visit[i], false);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visit[i][j]) continue;

                switch (input[i][j]) {
                    case 'R':
                    case 'G':
                        queue.clear();
                        queue.add(new Point(i, j));
                        visit[i][j] = true;
                        red++;

                        while (!queue.isEmpty()) {
                            Point cur = queue.poll();

                            for (int n = 0; n < 4; n++) {
                                int nextX = cur.x + dirX[n];
                                int nextY = cur.y + dirY[n];

                                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) continue;
                                if (visit[nextX][nextY] || input[nextX][nextY] == 'B') continue;

                                visit[nextX][nextY] = true;
                                queue.add(new Point(nextX, nextY));
                            }
                        }
                        break;
                    case 'B':
                        queue.clear();
                        queue.add(new Point(i, j));
                        visit[i][j] = true;
                        blue++;

                        while (!queue.isEmpty()) {
                            Point cur = queue.poll();

                            for (int n = 0; n < 4; n++) {
                                int nextX = cur.x + dirX[n];
                                int nextY = cur.y + dirY[n];

                                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) continue;
                                if (visit[nextX][nextY] || input[nextX][nextY] != 'B') continue;

                                visit[nextX][nextY] = true;
                                queue.add(new Point(nextX, nextY));
                            }
                        }
                        break;
                }
            }
        }

        sb.append(red + blue);
        System.out.println(sb);
        br.close();
    }
}
