import java.io.*;
import java.util.*;

public class BOJ_2636 {
    private static int[][] arr;
    private static int N, M;
    private static int[] dirX = {-1, 0, 1, 0};
    private static int[] dirY = {0, 1, 0, -1};

    private static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        int beforeSize = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) beforeSize++;
            }
        }
        br.close();

        int meltTime = 0;
        while (true) {
            if (isAllMelt()) break;

            Queue<Point> queue = new LinkedList<>();
            List<Point> meltCheese = new ArrayList<>();
            queue.add(new Point(0, 0));
            boolean[][] visit = new boolean[N][M];
            visit[0][0] = true;

            while (!queue.isEmpty()) {
                Point cur = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int nextX = cur.x + dirX[i];
                    int nextY = cur.y + dirY[i];

                    if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;
                    if (visit[nextX][nextY]) continue;

                    visit[nextX][nextY] = true;
                    if (arr[nextX][nextY] == 1) meltCheese.add(new Point(nextX, nextY));
                    if (arr[nextX][nextY] != 1) queue.add(new Point(nextX, nextY));
                }
            }

            for (Point cur : meltCheese) {
                arr[cur.x][cur.y] = 0;
            }

            meltTime++;
            if (isAllMelt()) break;

            beforeSize = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j] == 1) beforeSize++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(meltTime).append("\n").append(beforeSize);
        System.out.println(sb);
    }

    private static boolean isAllMelt() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 1) return false;
            }
        }
        return true;
    }
}
