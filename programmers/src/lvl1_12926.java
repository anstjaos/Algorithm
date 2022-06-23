public class lvl1_12926 {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == ' ') {
                sb.append(" ");
                continue;
            }
            if ('a' <= cur && cur <= 'z') {
                cur = (char) ((cur - 'a' + n) % 26 + 'a');
            } else if ('A' <= cur && cur <= 'Z') {
                cur = (char) ((cur - 'A' + n) % 26 + 'A');
            }
            sb.append(cur);
        }
        return sb.toString();
    }
}
