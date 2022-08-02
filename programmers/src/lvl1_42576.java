import java.util.*;

public class lvl1_42576 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> completionPerson = new HashMap<>();

        int length = completion.length;
        for (int i = 0; i < length; i++) {
            if (completionPerson.containsKey(completion[i])) {
                completionPerson.put(completion[i], completionPerson.get(completion[i]) + 1);
            } else {
                completionPerson.put(completion[i], 1);
            }
        }

        length = participant.length;
        for (int i = 0; i < length; i++) {
            if (!completionPerson.containsKey(participant[i])) {
                answer = participant[i];
                break;
            }

            int count = completionPerson.get(participant[i]);
            if (count == 0) {
                answer = participant[i];
                break;
            }

            completionPerson.put(participant[i], count - 1);
        }
        return answer;
    }
}
