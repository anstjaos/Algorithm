import java.io.*;
import java.util.*;

public class BOJ_1707 {
    private static Map<Integer, List<Integer>> graph;
    private static int[] visitNum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken()), E = Integer.parseInt(st.nextToken());

            graph = new LinkedHashMap<>();
            for (int i = 1; i <= V; i++) graph.put(i, new ArrayList<>());
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());

                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            String result = "YES";
            visitNum = new int[V + 1];

            for (int i = 1; i <= V; i++) {
                if (visitNum[i] == 0) {
                    if (!bfs(i)) {
                        result = "NO";
                        break;
                    }
                }
            }

            sb.append(result).append("\n");
        }
        br.close();
        System.out.print(sb);
    }

    private static boolean bfs(int index) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(index);
        visitNum[index] = 1;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            List<Integer> list = graph.get(cur);
            for (Integer next : list) {
                if (visitNum[cur] == visitNum[next]) return false;

                if (visitNum[next] == 0) {
                    visitNum[next] = visitNum[cur] * -1;
                    queue.add(next);
                }
            }
        }

        return true;
    }
}
