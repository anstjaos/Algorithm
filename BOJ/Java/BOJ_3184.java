import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3184 {
    private static int R, C;
    private static char[][] map;
    private static int[] dirX = {-1, 0, 1, 0};
    private static int[] dirY = { 0, -1, 0, 1};
    private static boolean[][] visit;

    private static class Survivor {
        int sheep, wolf;

        public Survivor(int sheep, int wolf) {
            this.sheep = sheep;
            this.wolf = wolf;
        }
    }

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
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visit = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = input.charAt(j);
            }
            Arrays.fill(visit[i], false);
        }
        br.close();

        Survivor result = new Survivor(0, 0);
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] != '#' && !visit[i][j]) {
                    Survivor survivor = getSurvivor(i, j);
                    result.sheep += survivor.sheep;
                    result.wolf += survivor.wolf;
                }
            }
        }

        System.out.println(result.sheep + " " + result.wolf);
    }

    private static Survivor getSurvivor(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        visit[x][y] = true;
        queue.add(new Point(x, y));

        Survivor survivor = new Survivor(0, 0);
        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            if (map[cur.x][cur.y] == 'o') survivor.sheep++;
            else if (map[cur.x][cur.y] == 'v') survivor.wolf++;

            for (int i = 0; i < 4; i++) {
                int nextX = cur.x + dirX[i], nextY = cur.y + dirY[i];

                if (nextX < 0 || nextY < 0 || nextX >= R || nextY >= C) continue;
                if (visit[nextX][nextY] || map[nextX][nextY] == '#') continue;

                visit[nextX][nextY] = true;
                queue.add(new Point(nextX, nextY));
            }
        }

        if (survivor.sheep > survivor.wolf) survivor.wolf = 0;
        else survivor.sheep = 0;

        return survivor;
    }
}
