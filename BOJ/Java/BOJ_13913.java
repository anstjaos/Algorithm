import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_13913 {
    private static int[] parent, visit;
    private static int N, K;

    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        br.close();

        parent = new int[300005];
        visit = new int[300005];

        solve();

        Stack<Integer> stack = new Stack<>();
        stack.push(K);
        int index = K;

        while (index != N) {
            stack.push(parent[index]);
            index = parent[index];
        }

        StringBuilder sb = new StringBuilder();
        sb.append(visit[K] - 1).append("\n");
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(sb);
    }

    private static void solve() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        visit[N] = 1;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            if (cur == K) return;

            for (int i = 0; i < 3; i++) {
                int next = 0;

                if (i == 0) next = cur + 1;
                else if (i == 1) next = cur - 1;
                else next = cur * 2;

                if (next < 0 || next > 100000) continue;

                if (visit[next] == 0) {
                    queue.add(next);
                    visit[next] = visit[cur] + 1;
                    parent[next] = cur;
                }
            }
        }
    }
}
