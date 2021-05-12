import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1197 {
    private static class Edge implements Comparable<Edge> {
        int from;
        int to;
        int cost;

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
        for (int i = 1; i<= V; i++) parent[i] = i;

        Edge[] edgeList = new Edge[E];
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            edgeList[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        br.close();
        Arrays.sort(edgeList);

        long result = 0;
        for (Edge edge: edgeList) {
            if (!isSameParent(edge.from, edge.to)) {
                union(edge.from, edge.to);
                result += edge.cost;
            }
        }

        System.out.println(result);
    }

    private static void union(int x, int y) {
        int xParent = findParent(x);
        int yParent = findParent(y);

        if (xParent != yParent) {
            parent[yParent] = xParent;
        }
    }

    private static boolean isSameParent(int x, int y) {
        int xParent = findParent(x);
        int yParent = findParent(y);

        return xParent == yParent;
    }

    private static int findParent(int x) {
        if (parent[x] == x) return x;

        return parent[x] = findParent(parent[x]);
    }
}
