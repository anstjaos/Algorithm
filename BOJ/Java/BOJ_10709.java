import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_10709 {
    private static int H, W;
    private static char[][] map;
    private static int[][] count;

    private static class Cloud {
        int x, y, count;

        public Cloud(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        map = new char[H+1][W+1];
        count = new int[H][W];

        for (int i = 0; i < H; i++) {
            String input = br.readLine();
            Arrays.fill(count[i], -1);
            for (int j = 0; j < W; j++) {
                map[i][j] = input.charAt(j);
            }
        }
        br.close();

        solve();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                sb.append(count[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    private static void solve() {
        Queue<Cloud> queue = new LinkedList<>();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (map[i][j] == 'c') {
                    queue.add(new Cloud(i, j, 0));
                }
            }
        }

        while (!queue.isEmpty()) {
            Cloud cur = queue.poll();

            if (count[cur.x][cur.y] == -1) {
                count[cur.x][cur.y] = cur.count;
            }

            if (cur.y + 1 < W) {
                queue.add(new Cloud(cur.x, cur.y + 1, cur.count + 1));
            }
        }
    }
}
