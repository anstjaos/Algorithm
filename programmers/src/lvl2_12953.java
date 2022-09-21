public class lvl2_12953 {
    public int solution(int[] arr) {
        int answer = arr[0];
        for (int i = 0; i < arr.length; i++){
            answer = getLcm(answer, arr[i]);
        }

        return answer;
    }

    private int getGcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }

    private int getLcm(int a, int b) {
        return a * b / getGcd(a, b);
    }
}
