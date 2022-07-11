public class lvl1_72410 {
    public String solution(String new_id) {
        String answer = "";
        new_id = new_id.toLowerCase();

        for (int i = 0; i < new_id.length(); i++) {
            char cur = new_id.charAt(i);
            if (('0' <= cur && cur <= '9')
                    || cur == '-'
                    || cur == '_'
                    || cur == '.'
                    || ('a' <= cur && cur <= 'z')) {
                answer += cur;
            }
        }

        String temp = "";
        int count = 0;
        for (int i = 0; i < answer.length(); i++) {
            char cur = answer.charAt(i);
            if (count >= 1 && cur == '.') {
                count++;
            } else if (cur == '.') {
                count = 1;
                temp += cur;
            } else {
                count = 0;
                temp += cur;
            }
        }

        answer = temp;
        if (answer.charAt(0) == '.') {
            answer = answer.substring(1, answer.length());
        }
        if (answer.length() >= 1 && answer.charAt(answer.length() - 1) == '.') {
            answer = answer.substring(0, answer.length() - 1);
        }

        if (answer.length() == 0) answer = "a";

        if (answer.length() >= 16) {
            answer = answer.substring(0, 15);
        }

        if (answer.length() >= 1 && answer.charAt(answer.length() - 1) == '.') {
            answer = answer.substring(0, answer.length() - 1);
        }

        if (answer.length() <= 2) {
            char cur = answer.charAt(answer.length() - 1);
            for (int i = 0; i <= 3 - answer.length(); i++) {
                answer += cur;
            }
        }
        return answer;
    }
}
