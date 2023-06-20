import java.util.*;

public class lvl2_72411 {
    private Map<String, Integer> combinationMap = new HashMap<>();

    public String[] solution(String[] orders, int[] course) {
        for (int i = 0; i < orders.length; i++) {
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = String.valueOf(arr);
        }

        List<String> answer = new ArrayList<>();
        for (int c : course) {
            for (String order : orders) {
                combination(order, new StringBuilder(), 0, 0, c);
            }

            if (!combinationMap.isEmpty()) {
                List<Integer> countList = new ArrayList<>(combinationMap.values());
                int max = Collections.max(countList);

                if (max > 1) {
                    for (String key : combinationMap.keySet()) {
                        if (combinationMap.get(key) == max) {
                            answer.add(key);
                        }
                    }
                }
            }

            combinationMap.clear();
        }

        Collections.sort(answer);
        return answer.toArray(String[]::new);
    }

    private void combination(String order, StringBuilder sb, int index, int count, int courseLength) {
        if (count == courseLength) {
            combinationMap.put(sb.toString(), combinationMap.getOrDefault(sb.toString(), 0) + 1);
            return;
        }

        for (int i = index; i < order.length(); i++) {
            sb.append(order.charAt(i));
            combination(order, sb, i + 1, count + 1, courseLength);
            sb.delete(count, count + 1);
        }
    }
}
