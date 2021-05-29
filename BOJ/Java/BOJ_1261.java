import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1261 {
    private static class Move implements Comparable<Move> {
        int x, y, count;

        public Move(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }

        @Override
        public int compareTo(Move o) {
            return this.count - o.count;
        }
    }

    private static int[] dirX = {-1, 0, 1, 0};
    private static int[] dirY = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        String[] map = new String[M];
        for (int i = 0; i < M; i++) {
            map[i] = br.readLine();
        }
        br.close();

        boolean[][][] visit = new boolean[M][N][10001];

        PriorityQueue<Move> pq = new PriorityQueue<>();
        pq.add(new Move(0, 0, 0));
        visit[0][0][0] = true;

        int result = 0;
        while (!pq.isEmpty()) {
            Move cur = pq.poll();
            if (cur.x == M -1 && cur.y == N - 1) {
                result = cur.count;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = cur.x + dirX[i];
                int nextY = cur.y + dirY[i];

                if (nextX < 0 || nextY < 0 || nextX >= M || nextY >= N) continue;
                char next = map[nextX].charAt(nextY);
                int nextCount = cur.count;

                if (next == '1') nextCount++;

                if (visit[nextX][nextY][nextCount]) continue;
                visit[nextX][nextY][nextCount] = true;
                pq.add(new Move(nextX, nextY, nextCount));
            }
        }

        System.out.println(result);
    }
}
