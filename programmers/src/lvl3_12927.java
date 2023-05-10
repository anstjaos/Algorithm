import java.util.*;

public class lvl3_12927 {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int work : works) pq.offer(work);

        while (n > 0) {
            int work = pq.poll();
            if (work == 0) break;
            work--;
            pq.offer(work);
            n--;
        }

        long answer = 0;
        while (!pq.isEmpty()) {
            int work = pq.poll();
            answer += (work * work);
        }

        return answer;
    }
}
