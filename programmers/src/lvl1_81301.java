public class lvl1_81301 {
    public int solution(String s) {
        int answer = 0;
        int length = s.length();

        for (int i = 0; i < length; i++) {
            char cur = s.charAt(i);
            answer = answer * 10;

            if ('0' <= cur && cur <= '9') {
                answer += (cur - '0');
                continue;
            }
            char next = s.charAt(i+1);

            switch (cur) {
                case 'z':
                    i += 3;
                    break;
                case 'o':
                    answer = answer + 1;
                    i += 2;
                    break;
                case 't':
                    if (next == 'w') {
                        answer += 2;
                        i += 2;
                    } else {
                        answer += 3;
                        i += 4;
                    }
                    break;
                case 'f':
                    if (next == 'o') {
                        answer += 4;
                        i += 3;
                    } else {
                        answer += 5;
                        i += 3;
                    }
                    break;
                case 's':
                    if (next == 'i') {
                        answer += 6;
                        i += 2;
                    } else {
                        answer += 7;
                        i += 4;
                    }
                    break;
                case 'e':
                    answer += 8;
                    i += 4;
                    break;
                case 'n':
                    answer += 9;
                    i += 3;
                    break;
            }
        }
        return answer;
    }
}
