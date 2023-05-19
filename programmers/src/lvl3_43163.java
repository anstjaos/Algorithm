import java.util.*;

public class lvl3_43163 {
    public int solution(String begin, String target, String[] words) {
        if (Arrays.stream(words).noneMatch(word -> word.equals(target))) {
            return 0;
        }
        Set<String> visit = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(begin);
        visit.add(begin);

        int count = -1;
        boolean isSuccess = false;
        while (!queue.isEmpty()) {
            count++;
            for (int i = 0; i < queue.size(); i++) {
                String cur = queue.poll();
                if (cur.equals(target)) {
                    isSuccess = true;
                    break;
                }
                for (int j = 0; j < cur.length(); j++) {
                    for (int k = 0; k < 26; k++) {
                        String next = getNextWord(cur, j, k);
                        if (visit.contains(next) || !Arrays.asList(words).contains(next)) continue;

                        visit.add(next);
                        queue.add(next);
                    }
                }
            }
        }
        if (isSuccess) return count;
        return 0;
    }

    private String getNextWord(String word, int changeIndex, int nextCharIndex) {
        StringBuilder next = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (i != changeIndex) next.append(word.charAt(i));
            else next.append((char) ('a' + nextCharIndex));
        }

        return next.toString();
    }
}
