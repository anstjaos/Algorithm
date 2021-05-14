import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_4386 {
    private static class Node {
        double x, y;

        public Node(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    private static class Edge implements Comparable<Edge> {
        int a, b;
        double distance;

        public Edge(int a, int b, double distance) {
            this.a = a;
            this.b = b;
            this.distance = distance;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.distance, o.distance);
        }
    }

    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            nodes[i] = new Node(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
        }

        br.close();
        List<Edge> edgeList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                edgeList.add(new Edge(i, j, getDistance(nodes[i], nodes[j])));
            }
        }

        Collections.sort(edgeList);
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        double result = 0.0;
        for (Edge edge : edgeList) {
            if (findParent(edge.a) != findParent(edge.b)) {
                union(edge.a, edge.b);
                result += edge.distance;
            }
        }

        System.out.println(result);
    }

    private static double getDistance(Node a, Node b) {
        return Math.sqrt(Math.pow(b.x - a.x, 2) + Math.pow(b.y - a.y, 2));
    }

    private static void union(int x, int y) {
        x = findParent(x);
        y = findParent(y);

        if (x != y) {
            parent[y] = x;
        }
    }

    private static int findParent(int x) {
        if (parent[x] == x) return x;
        return parent[x] = findParent(parent[x]);
    }
}
