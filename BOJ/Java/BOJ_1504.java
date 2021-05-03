import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1504 {
    private static int N, E;
    private static int[][] weight;
    private static int[][] cost;

    private static class Node implements Comparable<Node> {
        int cur;
        int cost;

        public Node(int cur, int cost) {
            this.cur = cur;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        weight = new int[N+1][N+1];
        cost = new int[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            Arrays.fill(weight[i], Integer.MAX_VALUE);
            Arrays.fill(cost[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()), to = Integer.parseInt(st.nextToken()), cost = Integer.parseInt(st.nextToken());
            weight[from][to] = Integer.min(weight[from][to], cost);
            weight[to][from] = Integer.min(weight[to][from], cost);
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken()), v2 = Integer.parseInt(st.nextToken());

        br.close();

        getCost(1);
        getCost(v1);
        getCost(v2);

        long startToV1 = cost[1][v1], startToV2 = cost[1][v2];
        long v1ToV2 = cost[v1][v2], v1ToN = cost[v1][N];
        long v2ToV1 = cost[v2][v1], v2ToN = cost[v2][N];

        long result1 = 0, result2 = 0;
        result1 = startToV1 + v1ToV2 + v2ToN;
        result2 = startToV2 + v2ToV1 + v1ToN;

        if (v1 == 1) {
            if (v2 == 1 || v2 == N) result1 = cost[1][N];
            else result1 = startToV2 + v2ToN;
        } else if (v2 == 1) {
            if (v1 == N) result1 = result1 = cost[1][N];
            else result1 = startToV1 + v1ToN;
        }

        if (result1 >= Integer.MAX_VALUE && result2 >= Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }

        if (result1 < result2) System.out.println(result1);
        else System.out.println(result2);
    }

    private static void getCost(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.cost > cost[start][cur.cur]) continue;

            for (int i = 1; i <= N; i++) {
                if (weight[cur.cur][i] == Integer.MAX_VALUE) continue;
                if (cur.cost + weight[cur.cur][i] > cost[start][i]) continue;

                cost[start][i] = cur.cost + weight[cur.cur][i];
                pq.add(new Node(i, cost[start][i]));
            }
        }
    }
}
