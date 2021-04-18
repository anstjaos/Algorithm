import java.io.*;
import java.util.*;

public class BOJ_2667 {
    private static int[] dirX = {-1, 0, 1, 0};
    private static int[] dirY = {0, 1, 0, -1};
    private static String[] graph;
    private static boolean[][] visit;

    private static class Direction {
        int x;
        int y;

        public Direction(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        graph = new String[N];
        for (int i = 0; i < N; i++) graph[i] = br.readLine();

        visit = new boolean[N][N];

        List<Integer> count = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i].charAt(j) == '1' && !visit[i][j]) {
                    count.add(bfs(i, j, N));
                }
            }
        }
        count.sort(Comparator.comparingInt(a -> a));

        StringBuilder sb = new StringBuilder();
        sb.append(count.size()).append("\n");
        for (Integer c : count) {
            sb.append(c).append("\n");
        }

        System.out.print(sb);
        br.close();
    }

    private static int bfs(int x, int y, int size) {
        int result = 0;
        Queue<Direction> queue = new LinkedList<>();
        queue.add(new Direction(x, y));
        visit[x][y] = true;

        while (!queue.isEmpty()) {
            Direction cur = queue.poll();
            result++;

            for (int i = 0; i < 4; i++) {
                int nextX = cur.x + dirX[i];
                int nextY = cur.y + dirY[i];

                if (nextX < 0 || nextY < 0 || nextX >= size || nextY >= size) continue;
                if (graph[nextX].charAt(nextY) == '0' || visit[nextX][nextY]) continue;

                visit[nextX][nextY] = true;
                queue.add(new Direction(nextX, nextY));
            }
        }

        return result;
    }
}
