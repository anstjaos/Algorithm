import java.io.*;
import java.util.PriorityQueue;

public class BOJ_1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.add(Long.parseLong(br.readLine()));
        }
        br.close();

        long result = 0;
        while (pq.size() > 1) {
            long sum = pq.poll();
            long sum1 = pq.poll();

            result += sum + sum1;
            pq.add(sum + sum1);
        }

        System.out.println(result);
    }
}
