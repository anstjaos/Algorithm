public class lvl2_12924 {
    public int solution(int n) {
        int answer = 1;
        int left = 1, right = 2;

        int sum = 3;
        while (right < n) {
            if (sum < n) {
                right++;
                sum += right;
            } else if (sum > n) {
                sum -= left;
                left++;
            } else {
                answer++;
                sum -= left;
                left++;
            }
        }
        return answer;
    }
}
