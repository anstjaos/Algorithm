import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1389 {
    private static class Person {
        int index;
        int count;

        public Person(int index, int count) {
            this.index = index;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        boolean[][] graph = new boolean[N+1][N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            graph[a][b] = graph[b][a] = true;
        }

        int[] result = new int[N+1];
        for (int i = 1; i <= N; i++) {
            int sum = 0;
            Queue<Person> queue = new LinkedList<>();
            boolean[] visit = new boolean[N+1];

            queue.add(new Person(i, 0));
            while (!queue.isEmpty()) {
                Person cur = queue.poll();
                if (visit[cur.index]) continue;

                visit[cur.index] = true;
                sum += cur.count;

                for (int j = 1; j <= N; j++) {
                    if (!graph[cur.index][j] || visit[j]) continue;

                    queue.add(new Person(j, cur.count+1));
                }
            }

            result[i] = sum;
        }

        int minCount = Integer.MAX_VALUE, minIndex = 0;
        for (int i = 1; i <= N; i++) {
            if (result[i] < minCount) {
                minIndex = i;
                minCount = result[i];
            }
        }

        System.out.println(minIndex);
        br.close();
    }
}
