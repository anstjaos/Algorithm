import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_11725 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] parent = new int[N+1];

        Map<Integer, List<Integer>> node = new HashMap<>();
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());

            pushToMap(node, a, b);
            pushToMap(node, b, a);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            List<Integer> arr = node.get(cur);

            for (Integer next : arr) {
                if (parent[next] != 0) continue;
                parent[next] = cur;
                queue.add(next);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            sb.append(parent[i]).append("\n");
        }

        System.out.print(sb);
        br.close();
    }

    private static void pushToMap(Map<Integer, List<Integer>> node, int a, int b) {
        if (!node.containsKey(a)) {
            List<Integer> arr = new ArrayList<>();
            arr.add(b);
            node.put(a, arr);
        } else {
            List<Integer> arr = node.get(a);
            arr.add(b);
            node.put(a, arr);
        }
    }
}
