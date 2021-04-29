import java.io.*;
import java.util.*;

public class BOJ_1753 {
    private static class Edge implements Comparable<Edge>{
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken()), E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        List<Edge>[] edgeList = new ArrayList[V+1];
        for (int i = 1; i <= V; i++) {
            edgeList[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()), to = Integer.parseInt(st.nextToken()), weight = Integer.parseInt(st.nextToken());

            edgeList[from].add(new Edge(to, weight));
        }

        int[] cost = new int[V+1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[K] = 0;
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        queue.add(new Edge(K, 0));

        boolean[] visit = new boolean[V+1];

        while (!queue.isEmpty()) {
            Edge cur = queue.poll();

            if (visit[cur.to]) continue;
            visit[cur.to] = true;

            for (Edge edge : edgeList[cur.to]) {
                if (cost[edge.to] > cost[cur.to] + edge.weight) {
                    cost[edge.to] = cost[cur.to] + edge.weight;
                    queue.add(new Edge(edge.to, cost[edge.to]));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (i == K) {
                sb.append(0).append("\n");
                continue;
            }
            if (cost[i] == Integer.MAX_VALUE) sb.append("INF").append("\n");
            else sb.append(cost[i]).append("\n");
        }

        System.out.print(sb);
        br.close();
    }
}
