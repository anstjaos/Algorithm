import java.io.*;
import java.util.*;

public class BOJ_2146 {
    private static int[][] map;
    private static int N;
    private static int[] dirX = {-1, 0, 1, 0};
    private static int[] dirY = {0, 1, 0, -1};

    private static class Land implements Comparable<Land> {
        int x, y, count;

        public Land(int x, int y) {
            this.x = x;
            this.y = y;
            this.count = 0;
        }

        public Land(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }

        @Override
        public int compareTo(Land o) {
            return this.count - o.count;
        }
    }

    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        N = Integer.parseInt(br.readLine());

        map = new int[N+1][N+1];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        int num = 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    makeIsland(new Land(i, j), num);
                    num++;
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0) continue;

                result = Integer.min(result, getShortWay(new Land(i, j)));
            }
        }

        System.out.println(result);
    }

    private static void makeIsland(Land start, int num) {
        Queue<Land> queue = new LinkedList<>();
        queue.add(start);
        map[start.x][start.y] = num;

        while (!queue.isEmpty()) {
            Land cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = cur.x + dirX[i], nextY = cur.y + dirY[i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) continue;
                if (map[nextX][nextY] != 1) continue;

                map[nextX][nextY] = num;
                queue.add(new Land(nextX, nextY));
            }
        }
    }

    private static int getShortWay(Land start) {
        Queue<Land> queue = new LinkedList<>();
        queue.add(start);
        int curNum = map[start.x][start.y];
        boolean[][] visit = new boolean[N+1][N+1];
        visit[start.x][start.y] = true;

        int result = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            Land cur = queue.poll();

            boolean isFind = false;
            for (int i = 0; i < 4; i++) {
                int nextX = cur.x + dirX[i], nextY = cur.y + dirY[i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) continue;
                if (map[nextX][nextY] == curNum || visit[nextX][nextY]) continue;
                if (map[nextX][nextY] != 0) {
                    result = cur.count;
                    isFind = true;
                    break;
                }
                visit[nextX][nextY] = true;
                queue.add(new Land(nextX, nextY, cur.count + 1));
            }

            if (isFind) break;
        }

        return result;
    }
}
