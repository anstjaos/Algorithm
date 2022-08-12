public class lvl2_12911 {
    public int solution(int n) {
        int oneCount = 0;
        int temp = n;
        while (temp != 0) {
            if (temp % 2 == 1) oneCount++;
            temp /= 2;
        }
        int answer = n + 1;
        while (true) {
            int curOneCount = 0;
            temp = answer;
            while (temp != 0) {
                if (temp % 2 == 1) curOneCount++;
                temp /= 2;
            }
            if (curOneCount == oneCount) {
                break;
            }
            answer++;
        }
        return answer;
    }
}
