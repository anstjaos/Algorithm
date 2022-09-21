import java.util.*;

public class lvl2_12981 {
    public int[] solution(int n, String[] words) {
        int[] sayCount = new int[n];
        int curIndex = 0;
        int wordCount = 0;
        char lastWord = '0';
        Set<String> sayedWords = new HashSet<>();

        while (wordCount < words.length) {
            sayCount[curIndex]++;

            String nextWord = words[wordCount];
            if (sayedWords.contains(nextWord)) break;
            if (lastWord != '0' && lastWord != nextWord.charAt(0)) break;

            sayedWords.add(nextWord);
            lastWord = nextWord.charAt(nextWord.length() - 1);
            curIndex = (curIndex + 1) % n;
            wordCount++;
        }

        int[] answer = new int[2];
        if (wordCount < words.length) {
            answer[0] = curIndex + 1;
            answer[1] = sayCount[curIndex];
        } else {
            answer[0] = 0;
            answer[1] = 0;
        }

        return answer;
    }
}
