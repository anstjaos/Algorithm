import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1697 {
    private static final int ARR_SIZE = 100007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        int[] count = new int[ARR_SIZE];
        Arrays.fill(count, Integer.MAX_VALUE);
        count[N] = 0;

        queue.add(N);
        while (!queue.isEmpty()) {
            int cur = queue.poll();

            if (cur - 1 >= 0 && count[cur] + 1 < count[cur - 1]) {
                count[cur - 1] = count[cur] + 1;
                queue.add(cur - 1);
            }
            if (cur + 1 <= 100000 && count[cur] + 1 < count[cur + 1]) {
                count[cur + 1] = count[cur] + 1;
                queue.add(cur + 1);
            }
            if (cur * 2 <= 100000 && count[cur] + 1 < count[cur * 2]) {
                count[cur * 2] = count[cur] + 1;
                queue.add(cur * 2);
            }
        }

        System.out.println(count[K]);
        br.close();
    }
}
