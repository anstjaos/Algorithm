public class sc1_2 {
    public boolean solution(String s) {
        boolean answer = true;
        if (s.length() != 4 && s.length() != 6) {
            answer = false;
            return answer;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!('0' <= c && c <= '9')) {
                answer = false;
                break;
            }
        }
        return answer;
    }
}
