import java.util.*;

public class lvl2_42578 {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for (String[] clothe : clothes) {
            map.put(clothe[1], map.getOrDefault(clothe[1], 0) + 1);
        }

        int answer = 1;
        for (String key : map.keySet()) {
            answer *= (map.get(key) + 1);
        }
        answer -= 1;
        return answer;
    }
}
