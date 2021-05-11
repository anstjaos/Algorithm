import java.io.*;
import java.util.*;

public class BOJ_12852 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();

        int[] from = new int[N + 1];
        int[] count = new int[N+1];
        Arrays.fill(count, Integer.MAX_VALUE);
        count[N] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == 1) break;

            if (cur % 3 == 0 && count[cur / 3] > count[cur] + 1) {
                count[cur/3] = count[cur]+1;
                from[cur/3] = cur;
                queue.add(cur / 3);
            }
            if (cur % 2 == 0 && count[cur/2] > count[cur] + 1) {
                count[cur/2] = count[cur] + 1;
                from[cur/2] = cur;
                queue.add(cur/2);
            }
            if (count[cur - 1] > count[cur] + 1) {
                count[cur-1] = count[cur] + 1;
                from[cur-1] = cur;
                queue.add(cur - 1);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(count[1]).append("\n");
        List<Integer> arr = new ArrayList<>();

        int cur = 1;
        while (true) {
            arr.add(cur);
            if (cur == N) break;
            cur = from[cur];
        }
        for (int i = arr.size() - 1; i>= 0; i--) sb.append(arr.get(i)).append(" ");

        System.out.println(sb);
    }
}
