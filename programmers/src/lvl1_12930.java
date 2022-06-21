public class lvl1_12930 {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == ' ') {
                sb.append(" ");
                count = 0;
                continue;
            }

            if (count % 2 == 0) {
                if ('A' <= cur && cur <= 'Z') sb.append(cur);
                else sb.append((char)(cur - 'a' + 'A'));
            } else {
                if ('A' <= cur && cur <= 'Z') sb.append((char)(cur - 'A' + 'a'));
                else sb.append(cur);
            }
            count++;
        }

        String answer = sb.toString();
        return answer;
    }
}
