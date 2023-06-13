import java.util.*;

public class lvl2_118667 {
    public int solution(int[] queue1, int[] queue2) {
        long sum = 0, queue1Sum = 0;
        Queue<Integer> q1 = new LinkedList<>();
        for (int num : queue1) {
            sum += num;
            queue1Sum += num;
            q1.add(num);
        }

        long queue2Sum = 0;
        Queue<Integer> q2 = new LinkedList<>();
        for (int num : queue2) {
            sum += num;
            queue2Sum += num;
            q2.add(num);
        }

        if ((sum & 1) == 1) return -1;

        int answer = 0;
        while (answer < queue1.length * 4) {
            if (queue1Sum == sum / 2) break;

            if (queue1Sum < sum / 2) {
                Integer num = q2.poll();
                queue1Sum += num;
                queue2Sum -= num;
                q1.add(num);
            } else {
                Integer num = q1.poll();
                queue1Sum -= num;
                queue2Sum += num;
                q2.add(num);
            }
            answer++;
        }

        if (answer == queue1.length * 4) return -1;
        return answer;
    }
}
