import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1865 {
    private static class Edge {
        int start;
        int end;
        int cost;

        public Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }

    private static int N;
    private static List<Edge> edgeList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (tc-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken()), W = Integer.parseInt(st.nextToken());

            edgeList = new ArrayList<>();
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken()), end = Integer.parseInt(st.nextToken()), weight = Integer.parseInt(st.nextToken());
                edgeList.add(new Edge(start, end, weight));
                edgeList.add(new Edge(end, start, weight));
            }

            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken()), end = Integer.parseInt(st.nextToken()), weight = Integer.parseInt(st.nextToken());
                edgeList.add(new Edge(start, end, weight * -1));
            }

            boolean isMinusCycle = false;
            for (int i = 1; i <= N; i++) {
                if (bellmanFord(i)) {
                    isMinusCycle = true;
                    break;
                }
            }

            sb.append(isMinusCycle ? "YES\n" : "NO\n");
        }
        br.close();

        System.out.print(sb);
    }

    private static boolean bellmanFord(int start) {
        int[] cost = new int[N+1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[start] = 0;

        boolean isUpdate = false;
        for (int i = 1; i < N; i++) {
            isUpdate = false;

            for (Edge edge : edgeList) {
                if (cost[edge.start] != Integer.MAX_VALUE && cost[edge.end] > cost[edge.start] + edge.cost) {
                    cost[edge.end] = cost[edge.start] + edge.cost;
                    isUpdate = true;
                }
            }

            if (!isUpdate) break;
        }

        if (isUpdate) {
            for (Edge edge : edgeList) {
                if (cost[edge.start] != Integer.MAX_VALUE && cost[edge.end] > cost[edge.start] + edge.cost) {
                    return true;
                }
            }
        }

        return false;
    }
}
