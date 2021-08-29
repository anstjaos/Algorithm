import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_2623 {
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int[] preCount = new int[N+1];
        List<List<Integer>> nextOrder = new ArrayList<>();

        for (int i = 0; i <= N; i++) nextOrder.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            int pre = 0;
            for (int j = 0; j < count; j++) {
                int cur = Integer.parseInt(st.nextToken());
                if (pre != 0) {
                    nextOrder.get(pre).add(cur);
                    preCount[cur]++;
                }
                pre = cur;
            }
        }
        br.close();

        int[] order = new int[N];
        int orderCount = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            if (preCount[i] == 0) pq.add(i);
        }

        while (!pq.isEmpty()) {
            int cur = pq.poll();
            order[orderCount++] = cur;

            List<Integer> nextList = nextOrder.get(cur);
            for (Integer next : nextList) {
                preCount[next]--;
                if (preCount[next] == 0) pq.offer(next);
            }
        }

        StringBuilder sb = new StringBuilder();
        if (orderCount != N) {
            sb.append(0).append("\n");
        } else {
            for (int i = 0; i < orderCount; i++) sb.append(order[i]).append("\n");
        }

        System.out.print(sb);
    }
}
