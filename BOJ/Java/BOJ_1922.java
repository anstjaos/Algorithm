import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1922 {
    private static int[] parent;
    private static class Node implements Comparable<Node> {
        int a, b, c;

        public Node(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public int compareTo(Node o) {
            return this.c - o.c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        Node[] nodeArr = new Node[M];
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            nodeArr[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(nodeArr);
        br.close();

        parent = new int[N+1];
        for (int i = 1; i <= N; i++) parent[i] = i;

        long cost = 0;
        int count = 0;
        for (int i = 0; i < M; i++) {
            if (count == N -1) break;
            Node cur = nodeArr[i];
            if (findParent(cur.a) == findParent(cur.b)) continue;

            cost += cur.c;
            count++;
            union(cur.a, cur.b);
        }

        System.out.println(cost);
    }

    private static void union(int a, int b) {
        a = findParent(a);
        b = findParent(b);

        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    private static int findParent(int a) {
        if (parent[a] == a) return a;
        return parent[a] = findParent(parent[a]);
    }
}
