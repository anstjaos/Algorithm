import java.io.*;
import java.util.*;

public class BOJ_7576 {
    private static int[] dirX = {-1, 0, 1, 0};
    private static int[] dirY = {0, 1, 0, -1};

    private static class Tomato {
        int x;
        int y;

        public Tomato(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken()), N = Integer.parseInt(st.nextToken());
        int[][] box = new int[N][M];

        Queue<Tomato> queue = new LinkedList<>();
        int[][] count = new int[N][M];

        int nonMature = 0;
        for (int j = 0; j < N; j++) {
            Arrays.fill(count[j], Integer.MAX_VALUE);
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < M; k++) {
                box[j][k] = Integer.parseInt(st.nextToken());
                if (box[j][k] == 1) {
                    count[j][k] = 0;
                    queue.add(new Tomato(j, k));
                } else if (box[j][k] == 0) {
                    nonMature++;
                }
            }
        }

        if (nonMature == 0) {
            System.out.println(0);
            return;
        }

        while (!queue.isEmpty()) {
            Tomato cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = cur.x + dirX[i];
                int nextY = cur.y + dirY[i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;
                if (box[nextX][nextY] != 0 || count[cur.x][cur.y] + 1 >= count[nextX][nextY]) continue;

                count[nextX][nextY] = count[cur.x][cur.y] + 1;
                queue.add(new Tomato(nextX, nextY));
            }
        }

        int result = 0;
        for (int j = 0; j < N; j++) {
            for (int k = 0; k < M; k++) {
                if (box[j][k] == 0) {
                    if (count[j][k] == Integer.MAX_VALUE) {
                        result = -1;
                        break;
                    }
                    result = Math.max(result, count[j][k]);
                }

            }
            if (result == -1) break;
        }

        System.out.println(result);
        br.close();
    }
}
