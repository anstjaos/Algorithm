public class lvl1_86051 {
    public int solution(int[] numbers) {
        int answer = 0;
        boolean[] isExist = new boolean[10];
        for (int i = 0; i < numbers.length; i++) {
            isExist[numbers[i]] = true;
        }

        for (int i = 0; i < 10; i++) {
            if (!isExist[i]) {
                answer += i;
            }
        }
        return answer;
    }
}
