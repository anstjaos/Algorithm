public class lvl1_12943 {
    public int solution(int num) {
        int answer = 0;
        long temp = num;
        while (temp != 1) {
            if (answer >= 500) {
                answer = -1;
                break;
            }

            if ((temp & 1) == 0) {
                temp /= 2;
            } else {
                temp = (temp * 3) + 1;
            }
            answer++;
        }
        return answer;
    }
}
