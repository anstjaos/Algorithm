import java.io.*;
import java.util.*;

public class BOJ_1260 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), V = Integer.parseInt(st.nextToken());
        boolean[][] graph = new boolean[N+1][N+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());

            graph[a][b] = true;
            graph[b][a] = true;
        }

        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();

        boolean[] visit = new boolean[N+1];
        stack.push(V);
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            if (visit[cur]) continue;

            visit[cur] = true;
            sb.append(cur).append(" ");
            for (int i = N; i >= 1; i--) {
                if (!visit[i] && graph[cur][i]) {
                    stack.push(i);
                }
            }
        }
        sb.append("\n");

        Arrays.fill(visit, false);
        queue.add(V);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (visit[cur]) continue;

            visit[cur] = true;
            sb.append(cur).append(" ");

            for (int i = 1; i <= N; i++) {
                if (!visit[i] && graph[cur][i]) {
                    queue.add(i);
                }
            }
        }

        System.out.println(sb);
        br.close();
    }
}
