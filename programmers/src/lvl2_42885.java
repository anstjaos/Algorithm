import java.util.*;

public class lvl2_42885 {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int min = 0, max = people.length - 1;

        while (min <= max) {
            if (people[min] + people[max] <= limit) {
                min++;
            }
            max--;
            answer++;
        }
        return answer;
    }
}
