import java.util.*;

public class lvl3_12987 {
    public int solution(int[] A, int[] B) {
        Integer[] aList = Arrays.stream(A).boxed().toArray(Integer[]::new);
        Arrays.sort(aList, Collections.reverseOrder());

        Integer[] bList = Arrays.stream(B).boxed().toArray(Integer[]::new);
        Arrays.sort(bList, Collections.reverseOrder());

        int answer = 0;
        int aIndex = 0, bIndex = 0;
        while (aIndex < A.length && bIndex < B.length) {
            if (aList[aIndex] < bList[bIndex]) {
                aIndex++;
                bIndex++;
                answer++;
            } else {
                aIndex++;
            }
        }
        return answer;
    }
}
