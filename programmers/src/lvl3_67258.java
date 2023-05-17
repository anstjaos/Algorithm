import java.util.*;

public class lvl3_67258 {
    public int[] solution(String[] gems) {
        int gemCount = (int) Arrays.stream(gems).distinct().count();

        int left = 0, right = 0;

        int distance = Integer.MAX_VALUE;
        int start = 1, end = 1;

        Map<String, Integer> gemMap = new HashMap<>();

        while (true) {
            if (gemMap.size() == gemCount) {
                if (distance > (right - left + 1)) {
                    distance = right - left + 1;
                    start = left + 1;
                    end = right;
                }

                gemMap.put(gems[left], gemMap.get(gems[left]) - 1);
                if (gemMap.get(gems[left]) == 0) {
                    gemMap.remove(gems[left]);
                }
                left++;
            } else if (right == gems.length) {
                break;
            } else {
                gemMap.put(gems[right], gemMap.getOrDefault(gems[right], 0) + 1);
                right++;
            }
        }
        int[] answer = {start, end};
        return answer;
    }
}
