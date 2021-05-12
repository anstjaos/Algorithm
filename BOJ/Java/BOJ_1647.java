import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1647 {
    private static class Edge implements Comparable<Edge> {
        int from, to, cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken()), E = Integer.parseInt(st.nextToken());

        parent = new int[V+1];
        for (int i = 1; i <= V; i++) parent[i] = i;

        Edge[] edgeList = new Edge[E];
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            edgeList[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(edgeList);
        br.close();

        long result = 0, maxCost = 0;
        for (Edge edge : edgeList) {
            if (findParent(edge.from) != findParent(edge.to)) {
                union(edge.from, edge.to);
                result += edge.cost;
                maxCost = edge.cost;
            }
        }

        System.out.println(result - maxCost);
    }

    private static void union(int x, int y) {
        x = findParent(x);
        y = findParent(y);

        if (x != y) parent[y] = x;
    }

    private static int findParent(int x) {
        if (parent[x] == x) return x;

        return parent[x] = findParent(parent[x]);
    }
}
