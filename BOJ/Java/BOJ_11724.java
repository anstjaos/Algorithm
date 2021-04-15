import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11724 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int[][] graph = new int[N+1][N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());

            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        boolean[] visit = new boolean[N+1];
        int result = 0;

        for (int i = 1; i <= N; i++) {
            if (visit[i]) continue;

            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);

            while (!queue.isEmpty()) {
                int cur = queue.poll();
                if (visit[cur]) continue;

                visit[cur] = true;
                for (int j = 1; j <= N; j++) {
                    if (graph[cur][j] == 0 || visit[j]) continue;

                    queue.add(j);
                }
            }
            result++;
        }

        System.out.println(result);
        br.close();
    }
}
