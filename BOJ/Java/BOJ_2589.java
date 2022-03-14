import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2589 {
    private static int[] dirX = { -1, 0, 1, 0 };
    private static int[] dirY = { 0, 1, 0, -1 };
    private static char[][] map;
    private static int L, W;

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

        L = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        map = new char[L + 1][W + 1];

        for (int i = 0; i < L; i++) {
            String input = br.readLine();
            for (int j = 0; j < W; j++) {
                map[i][j] = input.charAt(j);
            }
        }
        br.close();

        int result = -1;
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < W; j++) {
                if (map[i][j] == 'W') continue;

                result = Math.max(result, getMax(new Point(i, j)));
            }
        }

        System.out.println(result);
    }

    private static int getMax(Point start) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);
        int[][] isVisit = new int[L][W];
        for (int i = 0; i < L; i++) {
            Arrays.fill(isVisit[i], -1);
        }
        isVisit[start.x][start.y] = 0;

        int result = 0;
        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            result = Math.max(result, isVisit[cur.x][cur.y]);

            for (int i = 0; i < 4; i++) {
                int nextX = cur.x + dirX[i], nextY = cur.y + dirY[i];

                if (nextX < 0 || nextY < 0 || nextX >= L || nextY >= W) continue;
                if (isVisit[nextX][nextY] != -1 || map[nextX][nextY] == 'W') continue;

                isVisit[nextX][nextY] = isVisit[cur.x][cur.y] + 1;
                queue.add(new Point(nextX, nextY));
            }
        }

        return result;
    }
}
