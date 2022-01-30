import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2468 {
    private static int[] dirX = {-1, 0, 1, 0}, dirY = {0, 1, 0, -1};
    private static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][N];
        Set<Integer> numSet = new HashSet<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
                numSet.add(num);
            }
        }

        br.close();

        boolean[][] visit;
        int maxCount = 1;
        for (Integer num : numSet) {
            visit = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[i][j] <= num) visit[i][j] = true;
                }
            }

            int curCount = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visit[i][j]) continue;

                    curCount++;
                    Queue<Point> queue = new LinkedList<>();
                    queue.add(new Point(i, j));
                    visit[i][j] = true;

                    while (!queue.isEmpty()) {
                        Point cur = queue.poll();

                        for (int d = 0; d < 4; d++) {
                            int nextX = cur.x + dirX[d];
                            int nextY = cur.y + dirY[d];

                            if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) continue;
                            if (visit[nextX][nextY]) continue;

                            visit[nextX][nextY] = true;
                            queue.add(new Point(nextX, nextY));
                        }
                    }
                }
            }

            maxCount = Math.max(maxCount, curCount);
        }

        System.out.println(maxCount);
    }
}
