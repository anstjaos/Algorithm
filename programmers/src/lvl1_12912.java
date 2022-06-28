public class lvl1_12912 {
    public long solution(int a, int b) {
        long answer = 0;

        int temp = b;
        b = Math.max(a, b);
        a = Math.min(a, temp);
        for (int i = a; i <= b; i++) {
            answer += i;
        }
        return answer;
    }
}
