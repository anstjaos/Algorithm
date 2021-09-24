import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1926 {
    private static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int[] dirX = {-1, 0, 1, 0};
    private static int[] dirY = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }

        boolean[][] visit = new boolean[n][m];
        int count = 0, maxSize = 0;
        Queue<Point> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1 && !visit[i][j]) {
                    queue.add(new Point(i, j));
                    visit[i][j] = true;
                    int size = 0;
                    while (!queue.isEmpty()) {
                        Point cur = queue.poll();
                        size++;


                        for (int k = 0; k < 4; k++) {
                            int nextX = cur.x + dirX[k];
                            int nextY = cur.y + dirY[k];

                            if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) continue;
                            if (visit[nextX][nextY] == true || arr[nextX][nextY] == 0) continue;

                            queue.add(new Point(nextX, nextY));
                            visit[nextX][nextY] = true;
                        }
                    }

                    count++;
                    maxSize = Math.max(maxSize, size);
                }
            }
        }
        br.close();
        System.out.println(count);
        System.out.println(maxSize);
    }
}
