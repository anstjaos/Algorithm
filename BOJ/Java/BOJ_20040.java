import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_20040 {
    private static class Edge {
        int x, y;

        public Edge(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    private static int[] parent;
    private static Edge[] edges;
    private static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        edges = new Edge[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            edges[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        br.close();

        solve();
        System.out.println(result);
    }

    private static void solve() {
        int idx = 0;
        for (Edge edge : edges) {
            result++;

            int a = findParent(edge.x);
            int b = findParent(edge.y);

            if (a == b) return;
            union(edge.x, edge.y);
        }

        result = 0;
    }

    private static int findParent(int x) {
        if (x == parent[x]) return x;
        return parent[x] = findParent(parent[x]);
    }

    private static void union(int x, int y) {
        x = findParent(x);
        y = findParent(y);

        if (x != y) {
            if (x < y) parent[y] = x;
            else parent[x] = y;
        }
    }
}
