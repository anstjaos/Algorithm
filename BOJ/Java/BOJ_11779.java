import java.io.*;
import java.util.*;

public class BOJ_11779 {
    private static class Bus implements Comparable<Bus> {
        int index;
        int cost;

        public Bus(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Bus o) {
            return this.cost - o.cost;
        }
    }

    private static Map<Integer, List<Bus>> busMap;
    private static int[] from, cost;
    private static int start, end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        from = new int[n+1];
        cost = new int[n+1];
        busMap = new LinkedHashMap<>();
        for (int i = 1; i<= n; i++) {
            busMap.put(i, new ArrayList<>());
        }
        Arrays.fill(cost, Integer.MAX_VALUE);

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken()), t = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());
            busMap.get(f).add(new Bus(t, c));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        br.close();

        dijkstra();
        StringBuilder sb = new StringBuilder();
        sb.append(cost[end]).append("\n");

        List<Integer> wayList = new ArrayList<>();
        int cur = end;
        while (true) {
            wayList.add(cur);
            if (cur == start) break;
            cur = from[cur];
        }

        sb.append(wayList.size()).append("\n");
        int size = wayList.size();
        for (int i = size - 1; i >= 0; i--) sb.append(wayList.get(i)).append(" ");
        System.out.println(sb);
    }

    private static void dijkstra() {
        PriorityQueue<Bus> pq = new PriorityQueue<>();
        pq.add(new Bus(start, 0));
        cost[start] = 0;

        while (!pq.isEmpty()) {
            Bus cur = pq.poll();
            if (cur.index == end) {
                return;
            }

            List<Bus> list = busMap.get(cur.index);
            for (Bus next : list) {
                if (cost[next.index] > cur.cost + next.cost) {
                    cost[next.index] = cur.cost + next.cost;
                    from[next.index] = cur.index;
                    pq.add(new Bus(next.index, cost[next.index]));
                }
            }
        }
    }
}
