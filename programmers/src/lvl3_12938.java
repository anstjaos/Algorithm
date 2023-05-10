public class lvl3_12938 {
    public int[] solution(int n, int s) {
        if (s < n) {
            return new int[]{-1};
        }

        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = s / n;
        }

        for (int i = 0; i < s % n; i++) {
            answer[n - 1 - i]++;
        }
        return answer;
    }
}
