public class lvl1_12947 {
    public boolean solution(int x) {
        boolean answer = true;
        int sum = 0, temp = x;
        while (temp != 0) {
            sum += temp % 10;
            temp /= 10;
        }

        if (x % sum != 0) answer = false;
        return answer;
    }
}
