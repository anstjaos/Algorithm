import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2206 {
    private static int[] dirX = {-1, 0, 1, 0};
    private static int[] dirY = {0, 1, 0, -1};

    private static class Move {
        int x;
        int y;
        boolean isBreak;

        public Move(int x, int y, boolean isBreak) {
            this.x = x;
            this.y = y;
            this.isBreak = isBreak;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        String[] map = new String[N];
        int[][][] visit = new int[N][M][2];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine();
            for (int j = 0; j < M; j++) Arrays.fill(visit[i][j], Integer.MAX_VALUE);
        }
        br.close();

        Queue<Move> queue = new LinkedList<>();
        queue.add(new Move(0, 0, false));
        visit[0][0][0] = visit[0][0][1] = 1;

        while (!queue.isEmpty()) {
            Move cur = queue.poll();
            int count = (cur.isBreak ? visit[cur.x][cur.y][1] : visit[cur.x][cur.y][0]);

            for (int i = 0; i < 4; i++) {
                int nextX = cur.x + dirX[i];
                int nextY = cur.y + dirY[i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;
                int nextCount = (cur.isBreak ? visit[nextX][nextY][1] : visit[nextX][nextY][0]);
                if (count + 1 >= nextCount) continue;

                if (map[nextX].charAt(nextY) == '0') {
                    if (cur.isBreak) {
                        visit[nextX][nextY][1] = count + 1;
                    } else {
                        visit[nextX][nextY][0] = count + 1;
                    }
                    queue.add(new Move(nextX, nextY, cur.isBreak));
                } else if (map[nextX].charAt(nextY) == '1' && !cur.isBreak) {
                    visit[nextX][nextY][1] = count + 1;
                    queue.add(new Move(nextX, nextY, true));
                }
            }
        }

        int result = Math.min(visit[N-1][M-1][0], visit[N-1][M-1][1]);
        result = (result == Integer.MAX_VALUE ? -1 : result);
        System.out.println(result);
    }
}
