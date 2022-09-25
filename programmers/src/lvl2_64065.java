import java.util.*;

public class lvl2_64065 {
    class NumberCount implements Comparable<NumberCount> {
        int number, count;

        public NumberCount(int number, int count) {
            this.number = number;
            this.count = count;
        }

        @Override
        public int compareTo(NumberCount o) {
            return o.count - this.count;
        }
    }

    public int[] solution(String s) {
        int[] count = new int[100001];
        s = s.replaceAll("[{]", "").replaceAll("[}]", "").replaceAll("[,]", " ");
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == ' ') {
                count[num]++;
                num = 0;
            } else {
                num = num * 10 + (cur - '0');
            }
        }
        if (num != 0) {
            count[num]++;
        }

        List<NumberCount> lists = new ArrayList<>();
        for (int i = 0; i < 100001; i++) {
            if (count[i] != 0) {
                lists.add(new NumberCount(i, count[i]));
            }
        }
        Collections.sort(lists);
        int[] answer = new int[lists.size()];
        for (int i = 0; i < lists.size(); i++) {
            answer[i] = lists.get(i).number;
        }

        return answer;
    }
}
