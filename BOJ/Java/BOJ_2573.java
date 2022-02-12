import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2573 {
    private static class Ice {
        int x, y, zeroCount;

        public Ice(int x, int y, int zeroCount) {
            this.x = x;
            this.y = y;
            this.zeroCount = zeroCount;
        }
    }

    private static int[] dirX = {-1, 0, 1, 0};
    private static int[] dirY = {0, 1, 0, -1};
    private static int[][] ice;
    private static int N, M;

    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ice = new int[N+1][M+1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                ice[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        Queue<Ice> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (ice[i][j] == 0) continue;

                int zeroCount = 0;
                for (int k = 0; k < 4; k++) {
                    int nextX = i + dirX[k];
                    int nextY = j + dirY[k];

                    if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;
                    if (ice[nextX][nextY] == 0) zeroCount++;
                }

                queue.add(new Ice(i, j, zeroCount));
            }
        }
        int result = 0;

        while (!queue.isEmpty()) {
            if (checkIce() >= 2) {
                break;
            }

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Ice cur = queue.poll();
                int zeroCount = 0;
                for (int k = 0; k < 4; k++) {
                    int nextX = cur.x + dirX[k];
                    int nextY = cur.y + dirY[k];

                    if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;
                    if (ice[nextX][nextY] == 0) zeroCount++;
                }
                queue.add(new Ice(cur.x, cur.y, zeroCount));
            }

            for (int i = 0; i < size; i++) {
                Ice cur = queue.poll();
                ice[cur.x][cur.y] = Integer.max(0, ice[cur.x][cur.y] - cur.zeroCount);
                if (ice[cur.x][cur.y] != 0) queue.add(new Ice(cur.x, cur.y, 0));
            }

            result++;
        }

        if (checkIce() < 2) result = 0;

        System.out.println(result);
    }

    private static int checkIce() {
        int result = 0;
        boolean[][] visit = new boolean[N+1][M+1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (ice[i][j] != 0 && !visit[i][j]) {
                    result++;
                    Queue<Ice> queue = new LinkedList<>();
                    visit[i][j] =true;
                    queue.add(new Ice(i, j, 0));

                    while (!queue.isEmpty()) {
                        Ice cur = queue.poll();

                        for (int k = 0; k < 4; k++) {
                            int nextX = cur.x + dirX[k];
                            int nextY = cur.y + dirY[k];

                            if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;
                            if (visit[nextX][nextY] || ice[nextX][nextY] == 0) continue;

                            visit[nextX][nextY] = true;
                            queue.add(new Ice(nextX, nextY, 0));
                        }
                    }
                }
            }
        }

        return result;
    }
}
