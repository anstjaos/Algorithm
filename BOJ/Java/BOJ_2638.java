import java.io.*;
import java.util.*;

public class BOJ_2638 {
    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static List<Point> cheese;
    private static int N, M;
    private static int[][] arr;
    private static boolean[][] air;
    private static int[] dirX = {-1, 0, 1, 0};
    private static int[] dirY = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        air = new boolean[N][M];
        cheese = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) cheese.add(new Point(i, j));
            }
        }

        init();

        int result = 0;
        while (!cheese.isEmpty()) {
            result++;
            List<Point> removeCheese = new ArrayList<>();
            for (Point cur : cheese) {
                int airCount = 0;
                for (int i = 0; i < 4; i++) {
                    int nextX = cur.x + dirX[i];
                    int nextY = cur.y + dirY[i];

                    if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;
                    if (!air[nextX][nextY]) continue;

                    airCount++;
                }

                if (airCount >= 2) {
                    removeCheese.add(cur);
                }
            }

            for (Point cur: removeCheese) {
                arr[cur.x][cur.y] = 0;
                cheese.remove(cur);
            }
            setAir(new LinkedList<>(removeCheese));
        }

        System.out.println(result);
        br.close();
    }

    private static void init() {
        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            queue.add(new Point(0, i));
            queue.add(new Point(N-1, i));
        }
        for (int i = 1; i < N - 1; i++) {
            queue.add(new Point(i, 0));
            queue.add(new Point(i, M - 1));
        }

        setAir(queue);
    }

    private static void setAir(Queue<Point> queue) {
        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            if (air[cur.x][cur.y]) continue;
            air[cur.x][cur.y] = true;

            for (int i = 0; i < 4; i++) {
                int nextX = cur.x + dirX[i];
                int nextY = cur.y + dirY[i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;
                if (air[nextX][nextY] || arr[nextX][nextY] == 1) continue;

                queue.add(new Point(nextX, nextY));
            }
        }
    }
}
