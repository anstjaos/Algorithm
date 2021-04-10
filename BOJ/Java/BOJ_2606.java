import java.io.*;
import java.util.*;

public class BOJ_2606 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        StringTokenizer st;
        Map<Integer, List<Integer>> computer = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            computer.put(i, new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken()), to = Integer.parseInt(st.nextToken());
            computer.get(from).add(to);
            computer.get(to).add(from);
        }

        boolean[] virus = new boolean[N+5];
        Arrays.fill(virus, false);
        Queue<Integer> queue = new LinkedList();
        queue.add(1);

        int count = 0;
        while (!queue.isEmpty()) {
            int num = queue.poll();
            if (virus[num]) continue;

            List<Integer> curArr = computer.get(num);
            curArr.forEach(n -> {
                if (!virus[n]) {
                    queue.add(n);
                }
            });
            virus[num] = true;
            count++;
        }

        System.out.println(count-1);
        br.close();
    }
}
