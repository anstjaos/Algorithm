import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_2252 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        List<List<Integer>> preList = new ArrayList<>();
        for (int i = 0; i <= N; i++) preList.add(new ArrayList<>());

        int[] preCount = new int[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            preCount[b]++;
            preList.get(a).add(b);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            if (preCount[i] == 0) pq.add(i);
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Integer cur = pq.poll();
            sb.append(cur).append(" ");

            List<Integer> nextList = preList.get(cur);
            for (Integer next : nextList) {
                preCount[next]--;
                if (preCount[next] == 0) pq.offer(next);
            }
        }
        br.close();

        System.out.println(sb);
    }
}
