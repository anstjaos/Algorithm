import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_13549 {
    private static final int SIZE = 200007;
    private static class Move implements Comparable<Move> {
        int cur;
        int count;

        public Move(int cur, int count) {
            this.cur = cur;
            this.count = count;
        }

        @Override
        public int compareTo(Move o) {
            return this.count - o.count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        int[] visit = new int[SIZE];
        Arrays.fill(visit, Integer.MAX_VALUE);

        PriorityQueue<Move> pq = new PriorityQueue<>();
        pq.add(new Move(N, 0));

        int result = 0;
        while (!pq.isEmpty()) {
            Move cur = pq.poll();
            if (cur.cur == K) {
                result = cur.count;
                break;
            }

            if (cur.cur * 2 < SIZE && visit[cur.cur * 2] > cur.count) {
                visit[cur.cur * 2] = cur.count;
                pq.add(new Move(cur.cur * 2, cur.count));
            }
            if (cur.cur - 1 >= 0 && visit[cur.cur - 1] > cur.count + 1) {
                visit[cur.cur - 1] = cur.count + 1;
                pq.add(new Move(cur.cur - 1, cur.count + 1));
            }
            if (cur.cur + 1 < SIZE && visit[cur.cur + 1] > cur.count + 1) {
                visit[cur.cur + 1] = cur.count + 1;
                pq.add(new Move(cur.cur + 1, cur.count + 1));
            }
        }

        System.out.println(result);
        br.close();
    }
}
