import java.util.*;

public class lvl2_12941 {
    public int solution(int []A, int []B)
    {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);

        int length = A.length;
        for (int i = 0; i < length; i++) {
            answer += (A[i] * B[length - 1 - i]);
        }

        return answer;
    }
}
