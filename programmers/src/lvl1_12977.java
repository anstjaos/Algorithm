import java.util.*;

public class lvl1_12977 {
    public int solution(int[] nums) {
        boolean[] isPrime = new boolean[3005];
        Arrays.fill(isPrime, true);

        for (int i = 2; i * i < 3005; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < 3005; j+= i) {
                    isPrime[j] = false;
                }
            }
        }
        int answer = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int num = nums[i] + nums[j] + nums[k];
                    if (isPrime[num]) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }
}
