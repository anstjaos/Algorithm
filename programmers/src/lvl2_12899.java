public class lvl2_12899 {
    private int[] numbers = {4, 1, 2};

    public String solution(int n) {
        StringBuilder sb = new StringBuilder();

        while (n != 0) {
            int temp = n % 3;
            n /= 3;

            if (temp == 0) {
                n--;
            }
            sb.append(numbers[temp]);
        }

        String answer = sb.reverse().toString();
        return answer;
    }
}
