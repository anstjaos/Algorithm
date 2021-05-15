import java.io.*;
import java.util.*;

public class BOJ_1005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());

            int[] build = new int[N+1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) build[i] = Integer.parseInt(st.nextToken());

            Map<Integer, List<Integer>> edges = new LinkedHashMap<>();
            for (int i = 1; i <= N; i++) edges.put(i, new ArrayList<>());

            int[] in = new int[N+1];
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                in[to]++;
                edges.get(from).add(to);
            }

            Queue<Integer> queue = new LinkedList<>();
            int[] totalBuildTime = new int[N+1];
            for (int i = 1; i<= N; i++) {
                if (in[i] == 0) {
                    queue.add(i);
                    totalBuildTime[i] = build[i];
                }
            }

            while (!queue.isEmpty()) {
                int cur = queue.poll();

                List<Integer> nextBuild = edges.get(cur);
                for (Integer next : nextBuild) {
                    totalBuildTime[next] = Math.max(totalBuildTime[cur] + build[next], totalBuildTime[next]);
                    in[next]--;
                    if (in[next] == 0) queue.add(next);
                }
            }
            int W = Integer.parseInt(br.readLine());
            sb.append(totalBuildTime[W]).append("\n");
        }

        System.out.print(sb);
        br.close();
    }
}
