import java.util.*;

public class lvl2_17684 {
    public int[] solution(String msg) {
        int index = 1;
        Map<String, Integer> dictionary = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            dictionary.put((char) ('A' + i) + "", index++);
        }

        List<Integer> answer = new ArrayList<>();
        while (true) {
            int end = 1;
            boolean isEnd = false;

            while (true) {
                if (end == msg.length() + 1) {
                    isEnd = true;
                    break;
                }
                String sub = msg.substring(0, end);
                if (dictionary.getOrDefault(sub, 0) == 0) break;
                end++;
            }

            String dic = msg.substring(0, end - 1);
            answer.add(dictionary.get(dic));
            if (isEnd) break;

            dic += msg.charAt(end - 1);
            dictionary.put(dic, index++);
            System.out.println(dic);
            msg = msg.substring(end - 1);
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
