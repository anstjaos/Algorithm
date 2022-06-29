public class lvl1_82612 {
    public long solution(int price, int money, int count) {
        long sum = 0;
        for (int i = 1; i <= count; i++) {
            sum += (price * i);
        }

        long answer = -1;
        if (sum <= money) answer = 0;
        else {
            answer = sum - money;
        }

        return answer;
    }
}
