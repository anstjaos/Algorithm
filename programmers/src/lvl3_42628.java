import java.util.*;

public class lvl3_42628 {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());

        for (String operation : operations) {
            String[] parsed = operation.split(" ");
            int num = Integer.parseInt(parsed[1]);

            if (parsed[0].equals("I")) {
                minPq.offer(num);
                maxPq.offer(num);
            } else {
                if (num == 1 && maxPq.size() != 0) {
                    int maxVal = maxPq.poll();
                    minPq.remove(maxVal);
                } else if (num == -1 && minPq.size() != 0) {
                    int minVal = minPq.poll();
                    maxPq.remove(minVal);
                }
            }
        }
        int[] answer;

        if (maxPq.size() == 0) answer = new int[]{0, 0};
        else if (maxPq.size() == 1) answer = new int[]{maxPq.peek(), minPq.peek()};
        else {
            answer = new int[]{maxPq.peek(), minPq.peek()};
        }

        return answer;
    }
}
