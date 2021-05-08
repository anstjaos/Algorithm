import java.io.*;
import java.util.*;

public class BOJ_1167 {
    private static class Node {
        int index;
        int cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
    }
    private static int V;
    private static Map<Integer, List<Node>> edge;
    private static boolean[] visit;
    private static int maxCost;
    private static int maxNode;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());

        edge = new LinkedHashMap<>();
        for (int i = 1; i <= V; i++) edge.put(i, new ArrayList<>());

        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cur = Integer.parseInt(st.nextToken());

            while (true) {
                int to = Integer.parseInt(st.nextToken());
                if (to == -1) break;
                int cost = Integer.parseInt(st.nextToken());
                edge.get(cur).add(new Node(to, cost));
            }
        }

        visit = new boolean[V+1];
        dfs(1, 0);
        Arrays.fill(visit, false);
        maxCost = 0;
        dfs(maxNode, 0);

        br.close();

        System.out.println(maxCost);
    }

    private static void dfs(int cur, int cost) {
        if (visit[cur]) return;

        if (maxCost < cost) {
            maxCost = cost;
            maxNode = cur;
        }
        visit[cur] = true;

        List<Node> list = edge.get(cur);
        for (Node next : list) {
            dfs(next.index, cost + next.cost);
        }
    }
}
