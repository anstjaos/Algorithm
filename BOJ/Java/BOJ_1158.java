import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        br.close();

        int[] deleteArr = new int[N];
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) queue.add(i);

        int curCount = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            curCount++;
            if (curCount == K) {
                deleteArr[count++] = cur;
                curCount = 0;
                continue;
            }

            queue.add(cur);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for (int i = 0; i < N - 1; i++) sb.append(deleteArr[i]).append(", ");
        sb.append(deleteArr[N-1]).append(">");
        System.out.println(sb);
    }
}
