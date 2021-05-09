import java.io.*;
import java.util.*;

public class BOJ_1238 {
    private static class Move implements Comparable<Move> {
        int index;
        int cost;

        public Move(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Move o) {
            return this.cost - o.cost;
        }
    }

    private static int N, M, X;
    private static int[][] dist;
    private static Map<Integer, List<Move>> edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        edges = new LinkedHashMap<>();
        dist = new int[N+1][N+1];

        for (int i = 1; i<= N; i++) {
            edges.put(i, new ArrayList<>());
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()), to = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());
            edges.get(from).add(new Move(to, c));
        }
        br.close();

        for (int i = 1; i <= N; i++) {
            if (i == X) dijkstra(i, -1);
            else dijkstra(i, X);
        }

        int result = 0;
        for (int i = 1; i <= N; i++) {
            if (i == X) continue;
            result = Math.max(result, dist[i][X] + dist[X][i]);
        }

        System.out.println(result);
    }

    private static void dijkstra(int start, int dest) {
        PriorityQueue<Move> pq = new PriorityQueue<>();
        for (Move next : edges.get(start)) {
            dist[start][next.index] = next.cost;
            pq.add(new Move(next.index, next.cost));
        }

        while (!pq.isEmpty()) {
            Move cur = pq.poll();
            if (cur.index == dest) break;

            List<Move> list = edges.get(cur.index);

            for (Move next : list) {
                if (dist[start][cur.index] == Integer.MAX_VALUE) continue;
                if (dist[start][next.index] > dist[start][cur.index] + next.cost) {
                    dist[start][next.index] = dist[start][cur.index] + next.cost;
                    pq.add(new Move(next.index, dist[start][next.index]));
                }
            }
        }
    }
}
