import java.util.*;

public class lvl1_12933 {
    public long solution(long n) {
        int length = 0;
        long temp = n;

        while (temp != 0) {
            temp /= 10;
            length++;
        }

        long[] arr = new long[length];
        temp = n;

        int idx = 0;
        while (temp != 0) {
            arr[idx++] = temp % 10;
            temp /= 10;
        }

        Arrays.sort(arr);

        long answer = 0;
        for (int i = length - 1; i >= 0; i--) {
            answer = answer * 10 + arr[i];
        }
        return answer;
    }
}
