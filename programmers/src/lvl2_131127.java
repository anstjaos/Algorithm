import java.util.*;

public class lvl2_131127 {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> wantMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }

        int answer = 0;

        for (int i = 0; i <= discount.length - 10; i++) {
            Map<String, Integer> discountMap = new HashMap<>();
            for (int j = 0; j < 10; j++) {
                String d = discount[i + j];
                discountMap.put(d, discountMap.getOrDefault(d, 0) + 1);
            }

            boolean isExists = true;
            for (String food : wantMap.keySet()) {
                if (wantMap.get(food) > discountMap.getOrDefault(food, 0)) {
                    isExists = false;
                    break;
                }
            }

            if (isExists) answer++;
        }
        return answer;
    }
}
