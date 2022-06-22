public class lvl1_12925 {
    public int solution(String s) {
        int answer = 0;
        char first = s.charAt(0);

        if (first == '-' || first == '+') {
            int length = s.length();
            for (int i = 1; i < length; i++) {
                answer = (answer * 10) + (s.charAt(i) - '0');
            }

            if (first == '-') {
                answer *= -1;
            }
        } else {
            int length = s.length();
            for (int i = 0; i < length; i++) {
                answer = (answer * 10) + (s.charAt(i) - '0');
            }
        }

        return answer;
    }
}
