import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_12851 {
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

        int result = Integer.MAX_VALUE, count = 0;

        PriorityQueue<Move> queue = new PriorityQueue<>();
        queue.add(new Move(N, 0));
        int[] visit = new int[200007];
        Arrays.fill(visit, Integer.MAX_VALUE);

        while (!queue.isEmpty()) {
            Move cur = queue.poll();
            if (cur.count > result) break;
            if (cur.cur == K) {
                if (cur.count < result) {
                    result = cur.count;
                    count = 1;
                } else {
                    count++;
                }
                continue;
            }

            visit[cur.cur] = cur.count;

            if (cur.cur - 1 >= 0 && visit[cur.cur - 1] >= cur.count + 1) {
                queue.add(new Move(cur.cur - 1, cur.count + 1));
            }
            if (cur.cur + 1 < 100007 && visit[cur.cur + 1] >= cur.count + 1) {
                queue.add(new Move(cur.cur + 1, cur.count + 1));
            }
            if (cur.cur * 2 < 200007 && visit[cur.cur * 2] >= cur.count + 1) {
                queue.add(new Move(cur.cur * 2, cur.count + 1));
            }
        }

        System.out.println(result);
        System.out.println(count);
        br.close();
    }
}
