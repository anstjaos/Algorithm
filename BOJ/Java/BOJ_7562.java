import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_7562 {
    private static int[] dirX = {1, 2, 2, 1, -1, -2, -2, -1};
    private static int[] dirY = {2, 1, -1, -2, -2, -1, 1, 2};

    private static class Knight implements Comparable<Knight> {
        int x, y, count;

        public Knight(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }

        @Override
        public int compareTo(Knight o) {
            return this.count - o.count;
        }
    }

    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (tc-- > 0) {
            int l = Integer.parseInt(br.readLine());
            boolean[][] visit = new boolean[l][l];

            StringTokenizer st = new StringTokenizer(br.readLine());
            Knight cur = new Knight(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
            st = new StringTokenizer(br.readLine());
            Knight dest = new Knight(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);

            visit[cur.x][cur.y] = true;
            PriorityQueue<Knight> pq = new PriorityQueue<>();
            pq.add(cur);

            while (!pq.isEmpty()) {
                Knight curKnight = pq.poll();
                if (curKnight.x == dest.x && curKnight.y == dest.y) {
                    sb.append(curKnight.count).append("\n");
                    break;
                }

                for (int i = 0; i < 8; i++) {
                    int nextX = curKnight.x + dirX[i];
                    int nextY = curKnight.y + dirY[i];

                    if (nextX < 0 || nextY < 0 || nextX >= l || nextY >= l) continue;
                    if (visit[nextX][nextY]) continue;

                    visit[nextX][nextY] = true;
                    pq.add(new Knight(nextX, nextY, curKnight.count + 1));
                }
            }
        }
        br.close();
        System.out.print(sb);
    }
}
