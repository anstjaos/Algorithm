import java.util.*;

public class lvl2_12939 {
    public String solution(String s) {
        String[] list = s.split(" ");
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < list.length; i++) {
            numbers.add(Integer.parseInt(list[i]));
        }

        Collections.sort(numbers);
        String answer = numbers.get(0) + " " + numbers.get(list.length - 1);
        return answer;
    }
}
