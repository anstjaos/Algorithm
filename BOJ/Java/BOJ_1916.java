import java.io.*;
import java.util.*;

public class BOJ_1916 {
    private static class Edge implements Comparable<Edge> {
        int cur;
        int cost;

        public Edge(int cur, int cost) {
            this.cur = cur;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        StringTokenizer st;
        List<Edge>[] edgeList = new List[N+1];
        for (int i = 1; i <= N; i++) edgeList[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()), to = Integer.parseInt(st.nextToken()), w = Integer.parseInt(st.nextToken());
            edgeList[from].add(new Edge(to, w));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()), end = Integer.parseInt(st.nextToken());

        int[] cost = new int[N+1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[start] = 0;

        boolean[] visit = new boolean[N+1];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (cur.cur == end) break;
            if (visit[cur.cur]) continue;
            visit[cur.cur] = true;

            for (Edge edge : edgeList[cur.cur]) {
                if (cost[edge.cur] > cost[cur.cur] + edge.cost) {
                    cost[edge.cur] = cost[cur.cur] + edge.cost;
                    pq.add(new Edge(edge.cur, cost[edge.cur]));
                }
            }
        }

        System.out.println(cost[end]);

        br.close();
    }
}
