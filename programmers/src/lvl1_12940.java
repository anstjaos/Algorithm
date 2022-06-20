public class lvl1_12940 {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int gcd = getGcd(n, m);

        answer[0] = gcd;
        answer[1] = n * m / gcd;
        return answer;
    }

    public int getGcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}
