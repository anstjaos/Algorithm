import java.util.*;

public class lvl2_17677 {
    public int solution(String str1, String str2) {
        int answer = 0;
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        Map<String, Integer> aMap = new HashMap<>();
        for (int i = 0; i < str1.length() - 1; i++) {
            if (!isString(str1.charAt(i)) || !isString(str1.charAt(i +1))) continue;
            String s = str1.substring(i, i + 2);
            aMap.put(s, aMap.getOrDefault(s, 0) + 1);
        }

        Map<String, Integer> bMap = new HashMap<>();
        for (int i = 0; i < str2.length() - 1; i++) {
            if (!isString(str2.charAt(i)) || !isString(str2.charAt(i +1))) continue;
            String s = str2.substring(i, i + 2);
            bMap.put(s, bMap.getOrDefault(s, 0) + 1);
        }

        int same = 0, sum = 0;
        for (String aKey: aMap.keySet()) {
            if (bMap.containsKey(aKey)) {
                same += Math.min(aMap.get(aKey), bMap.get(aKey));
            }
        }

        Set<String> checkSet = new HashSet<>();
        for (String aKey: aMap.keySet()) {
            if (checkSet.contains(aKey)) {
                continue;
            }

            sum += Math.max(aMap.get(aKey), bMap.getOrDefault(aKey, 0));

            checkSet.add(aKey);
        }
        for (String bKey: bMap.keySet()) {
            if (checkSet.contains(bKey)) {
                continue;
            }

            sum += Math.max(bMap.get(bKey), aMap.getOrDefault(bKey, 0));
            checkSet.add(bKey);
        }
        if (sum == 0) {
            answer = 65536;
        } else {
            answer = (int) ((float)same / (float)sum * 65536.0);
        }
        return answer;
    }

    private boolean isString(char c) {
        if (!('a' <= c && c <= 'z')) return false;

        return true;
    }
}
