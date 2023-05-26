import java.util.*;

public class lvl2_138476 {
    class Tangerine {
        int number;
        int count;

        public Tangerine(int number, int count) {
            this.number = number;
            this.count = count;
        }

        public Tangerine() {}
    }

    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> tangerineMap = new HashMap<>();
        for (int tan : tangerine) {
            tangerineMap.put(tan, tangerineMap.getOrDefault(tan, 0) + 1);
        }

        List<Tangerine> tangerines = new ArrayList<>();
        for (Integer key : tangerineMap.keySet()) {
            tangerines.add(new Tangerine(key, tangerineMap.get(key)));
        }

        tangerines.sort((a, b) -> b.count - a.count);

        int answer = 0;
        for (int i = 0; i < tangerines.size() && k > 0; i++) {
            answer++;
            k -= tangerines.get(i).count;
        }
        return answer;
    }
}
