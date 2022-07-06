public class lvl1_68935 {
    public int solution(int n) {
        int answer = 0;
        int[] temp = new int[100005];
        int count = 0;

        int t = n;
        while (t != 0) {
            temp[count++] = t % 3;
            t /= 3;
        }

        int pow = 0;
        for (int i = count - 1; i >= 0; i--) {
            answer += (temp[i] * (int) Math.pow(3, pow));
            pow++;
        }
        return answer;
    }
}
