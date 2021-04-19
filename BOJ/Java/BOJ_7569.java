import javax.sound.midi.Soundbank;
import java.io.*;
import java.util.*;

public class BOJ_7569 {
    private static int[] dirX = {-1, 0, 1, 0};
    private static int[] dirY = {0, 1, 0, -1};

    private static class Tomato {
        int x;
        int y;
        int z;

        public Tomato(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken()), N = Integer.parseInt(st.nextToken()), H = Integer.parseInt(st.nextToken());
        int[][][] box = new int[H][N][M];

        Queue<Tomato> queue = new LinkedList<>();
        int[][][] count = new int[H][N][M];

        int nonMature = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                Arrays.fill(count[i][j], Integer.MAX_VALUE);
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                    if (box[i][j][k] == 1) {
                        count[i][j][k] = 0;
                        queue.add(new Tomato(j, k, i));
                    } else if (box[i][j][k] == 0) {
                        nonMature++;
                    }
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
                if (box[cur.z][nextX][nextY] != 0 || count[cur.z][cur.x][cur.y] + 1 >= count[cur.z][nextX][nextY]) continue;

                count[cur.z][nextX][nextY] = count[cur.z][cur.x][cur.y] + 1;
                queue.add(new Tomato(nextX, nextY, cur.z));
            }

            int nextZ = cur.z - 1;
            if (nextZ >= 0 && box[nextZ][cur.x][cur.y] == 0 && count[cur.z][cur.x][cur.y] + 1 < count[nextZ][cur.x][cur.y]) {
                count[nextZ][cur.x][cur.y] = count[cur.z][cur.x][cur.y] + 1;
                queue.add(new Tomato(cur.x, cur.y, nextZ));
            }

            nextZ = cur.z + 1;
            if (nextZ < H && box[nextZ][cur.x][cur.y] == 0 && count[cur.z][cur.x][cur.y] + 1 < count[nextZ][cur.x][cur.y]) {
                count[nextZ][cur.x][cur.y] = count[cur.z][cur.x][cur.y] + 1;
                queue.add(new Tomato(cur.x, cur.y, nextZ));
            }
        }

        int result = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (box[i][j][k] == 0) {
                        if (count[i][j][k] == Integer.MAX_VALUE) {
                            result = -1;
                            break;
                        }
                        result = Math.max(result, count[i][j][k]);
                    }

                }
                if (result == -1) break;
            }
            if (result == -1) break;
        }

        System.out.println(result);
        br.close();
    }
}
