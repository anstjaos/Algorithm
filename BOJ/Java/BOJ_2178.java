import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178 {
    private static int[] dirX = {-1, 0, 1, 0};
    private static int[] dirY = {0, 1, 0, -1};

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
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        String[] graph = new String[N];
        for (int i = 0; i < N; i++) {
            graph[i] = br.readLine();
        }

        int[][] count = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(count[i], Integer.MAX_VALUE);
        }
        Queue<Direction> queue = new LinkedList<>();
        queue.add(new Direction(0, 0));

        count[0][0] = 1;
        while (!queue.isEmpty()) {
            Direction cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = cur.x + dirX[i];
                int nextY = cur.y + dirY[i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;
                if (count[cur.x][cur.y] + 1 >= count[nextX][nextY] || graph[nextX].charAt(nextY) == '0') continue;

                count[nextX][nextY] = count[cur.x][cur.y] + 1;
                queue.add(new Direction(nextX, nextY));
            }
        }

        System.out.println(count[N-1][M-1]);
        br.close();
    }
}
