public class lvl2_12945 {
    private int[] memo = new int[100007];
    private static final int MOD = 1234567;

    public int solution(int n) {
        int answer =  getFibo(n);

        return answer;
    }

    private int getFibo(int n) {
        if (n <= 1) return n;
        if (memo[n] != 0) return memo[n];

        memo[n] = (getFibo(n-1) + getFibo(n-2)) % MOD;
        return memo[n];
    }
}
