import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1766 {
    private static class Problem implements Comparable<Problem> {
        int num, preCount;

        public Problem(int num, int preCount) {
            this.num = num;
            this.preCount = preCount;
        }

        @Override
        public int compareTo(Problem o) {
            if (this.preCount == o.preCount) {
                return this.num - o.num;
            }

            return this.preCount - o.preCount;
        }
    }

    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        Problem[] arr = new Problem[N+1];

        List<List<Integer>> preCountArr = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            arr[i] = new Problem(i, 0);
            preCountArr.add(new ArrayList<>());
        }
        preCountArr.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            arr[b].preCount++;
            preCountArr.get(a).add(b);
        }
        br.close();

        PriorityQueue<Problem> pq = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) pq.add(arr[i]);

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Problem cur = pq.poll();

            sb.append(cur.num).append(" ");
            List<Integer> list = preCountArr.get(cur.num);
            for (Integer next : list) {
                Problem problem = arr[next];
                problem.preCount--;
                pq.remove(problem);
                pq.add(problem);
            }
        }

        System.out.println(sb);
    }
}
