import java.util.*;

public class lvl2_84512 {
    String[] words;
    List<String> list;
    public int solution(String word) {
        int answer = 0;

        list = new ArrayList<>();
        words = new String[]{"A", "E", "I", "O", "U"};

        recursion(word, "", 0);

        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).equals(word)) {
                answer = i;
                break;
            }
        }
        return answer;
    }

    private void recursion(String word, String str, int depth) {
        list.add(str);

        if(depth == 5) {
            return;
        }

        for (int i = 0; i < words.length; i++) {
            recursion(word, str + words[i], depth + 1);
        }
    }
}
