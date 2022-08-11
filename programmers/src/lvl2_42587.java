import java.util.*;

class Document {
    int priority, location;

    public Document(int priority, int location) {
        this.priority = priority;
        this.location = location;
    }
}

public class lvl2_42587 {
    public int solution(int[] priorities, int location) {
        int answer = 1;
        Queue<Document> queue = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < priorities.length; i++) {
            queue.add(new Document(priorities[i], i));
            pq.add(priorities[i]);
        }

        while (!queue.isEmpty()) {
            Document document = queue.poll();
            if (document.priority == pq.peek()) {
                pq.poll();
                if (document.location == location) {
                    break;
                }
                answer++;
            } else {
                queue.add(document);
            }
        }
        return answer;
    }
}
