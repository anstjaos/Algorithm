import java.io.*;
import java.util.*;

public class BOJ_14938 {
    private static class Move implements Comparable<Move> {
        int cur;
        int limit;

        public Move(int cur, int limit) {
            this.cur = cur;
            this.limit = limit;
        }

        @Override
        public int compareTo(Move o) {
            return this.limit - o.limit;
        }
    }

    private static int n, m, r;
    private static int[] item;
    private static int[][] cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        item = new int[n + 1];
        cost = new int[n + 1][n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            item[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()), to = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());
            cost[from][to] = (cost[from][to] == 0 ? c : Integer.min(cost[from][to], c));
            cost[to][from] = (cost[to][from] == 0 ? c : Integer.min(cost[to][from], c));
        }
        br.close();

        int result = 0;
        for (int i = 1; i <= n; i++) {
            result = Math.max(result, dijkstra(i));
        }

        System.out.println(result);
    }

    public static int dijkstra(int start) {
        int[] dist = new int[n + 1];
        boolean[] check = new boolean[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(check, false);

        PriorityQueue<Move> pq = new PriorityQueue<>();
        pq.offer(new Move(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Move cur = pq.poll();
            int pos = cur.cur;

            if (!check[pos]) {
                check[pos] = true;

                for (int i = 1; i <= n; i++) {
                    if (check[i] || cost[pos][i] == 0) continue;

                    if (dist[i] > dist[pos] + cost[pos][i]) {
                        dist[i] = dist[pos] + cost[pos][i];
                        pq.add(new Move(i, dist[i]));
                    }
                }
            }
        }

        int res = 0;

        for (int i = 1; i <= n; i++) {
            if (dist[i] <= m) {
                res += item[i];
            }
        }

        return res;
    }
}
