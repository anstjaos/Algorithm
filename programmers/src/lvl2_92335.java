import java.util.*;

public class lvl2_92335 {
    public int solution(int n, int k) {
        StringBuilder sb = new StringBuilder();
        int temp = n;

        while (temp > 0) {
            sb.append(temp % k);
            temp /= k;
        }

        String numStr = sb.reverse().toString();
        int length = numStr.length();
        int answer = 0;

        int j = 0;
        for (int i = 0; i < length - 1; i = j) {
            for (j = i + 1; j < length && numStr.charAt(j) != '0'; j++) ;
            if (isPrime(Long.parseLong(numStr.substring(i, j))))
                answer++;
        }

        return answer;
    }

    private boolean isPrime(long n){
        if (n <= 1) return false;
        else if (n == 2) return true;

        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) return false;
        }

        return true;
    }
}
