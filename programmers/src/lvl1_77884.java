public class lvl1_77884 {
    public int solution(int left, int right) {
        int answer = 0;
        for (int i = left; i <= right; i++) {
            int count = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) count++;
            }

            if ((count & 1) == 1) {
                answer -= i;
            } else answer += i;
        }
        return answer;
    }
}
