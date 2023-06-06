import java.util.*;

public class lvl2_154538 {
    public int solution(int x, int y, int n) {
        if (x == y) return 0;
        int answer = -1;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);

        int count = 0;
        boolean[] isVisit = new boolean[y + 1];
        while (!queue.isEmpty()) {
            count++;
            boolean isSuccess = false;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer num = queue.poll();

                if (num + n <= y && !isVisit[num + n]) {
                    if (num + n == y) {
                        isSuccess = true;
                        break;
                    }

                    queue.add(num + n);
                    isVisit[num + n] = true;
                }
                if (num * 2 <= y && !isVisit[num * 2]) {
                    if (num * 2 == y) {
                        isSuccess = true;
                        break;
                    }
                    queue.add(num * 2);
                    isVisit[num * 2] = true;
                }
                if (num * 3 <= y && !isVisit[num * 3]) {
                    if (num * 3 == y) {
                        isSuccess = true;
                        break;
                    }
                    queue.add(num * 3);
                    isVisit[num * 3] = true;
                }
            }

            if (isSuccess) {
                answer = count;
                break;
            }
        }

        return answer;
    }
}
