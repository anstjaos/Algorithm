import java.util.*;

public class lvl2_42747 {
    public int solution(int[] citations) {
        Arrays.sort(citations);

        int answer = 0;

        for (int i = 0; i < citations.length; i++) {
            int minVal = Math.min(citations[i], citations.length - i);

            if (minVal >= answer) answer = minVal;
            else break;
        }
        return answer;
    }
}
