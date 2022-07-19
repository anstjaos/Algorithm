import java.util.*;

public class lvl2_42586 {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            if ((100 - progresses[i]) % speeds[i] == 0) {
                queue.add((100 - progresses[i]) / speeds[i]);
            } else {
                queue.add((100 - progresses[i]) / speeds[i] + 1);
            }
        }

        List<Integer> answerList = new ArrayList<>();
        int lastDay = 0, count = 0;
        while (!queue.isEmpty()) {
            int num = queue.poll();
            if (num > lastDay) {
                lastDay = num;
                if (count != 0) answerList.add(count);
                count = 1;
            } else {
                count++;
            }
        }
        answerList.add(count);
        return answerList.stream().mapToInt(i -> i).toArray();
    }
}
