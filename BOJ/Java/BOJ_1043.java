import java.io.*;
import java.util.*;

public class BOJ_1043 {
    private static int N, M;
    private static boolean[] knowTruth;
    private static boolean[][] graph;
    private static Map<Integer, List<Integer>> party;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        knowTruth = new boolean[N+1];
        graph = new boolean[N+1][N+1];

        st = new StringTokenizer(br.readLine());
        int count = Integer.parseInt(st.nextToken());
        while (count-- > 0) {
            knowTruth[Integer.parseInt(st.nextToken())] = true;
        }

        party = new LinkedHashMap<>();
        for (int i = 0; i < M; i++) {
            party.put(i, new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int partyCount = Integer.parseInt(st.nextToken());

            List<Integer> list = party.get(i);
            while (partyCount-- > 0) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            int size = list.size();
            for (int j = 0; j < size; j++) {
                for (int k = j + 1; k < size; k++) {
                    graph[list.get(j)][list.get(k)] = true;
                    graph[list.get(k)][list.get(j)] = true;
                }
            }

            party.put(i, list);
        }

        for (int i = 1; i <= N; i++) {
            if (knowTruth[i]) bfs(i);
        }
        br.close();

        int result = 0;
        for (int i = 0; i < M; i++) {
            List<Integer> list = party.get(i);
            boolean isKnow = false;
            for (Integer partyPeople : list) {
                if (knowTruth[partyPeople]) {
                    isKnow = true;
                    break;
                }
            }

            if (!isKnow) result++;
        }

        System.out.println(result);
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        boolean[] visit = new boolean[N+1];

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (visit[cur]) continue;
            visit[cur] = true;
            knowTruth[cur] = true;

            for (int i = 1; i <= N; i++) {
                if (graph[cur][i]) {
                    queue.add(i);
                }
            }
        }
    }
}
