import java.util.*;

public class lvl1_42862 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;

        boolean[] isReserve = new boolean[n + 5];
        for (int i = 0 ; i < reserve.length; i++) {
            isReserve[reserve[i]] = true;
        }
        Arrays.sort(lost);
        boolean[] isLost = new boolean[n + 5];
        for (int i = 0; i < lost.length; i++) {
            isLost[lost[i]] = true;
            if (isReserve[lost[i]]) {
                isReserve[lost[i]] = false;
                isLost[lost[i]] = false;
            }
        }

        for (int i = 0; i < lost.length; i++) {
            int cur = lost[i];
            if (!isLost[cur]) {
                answer++;
                continue;
            }

            if (isReserve[cur - 1]) {
                isReserve[cur - 1] = false;
                answer++;
            } else if (isReserve[cur + 1]) {
                isReserve[cur + 1] = false;
                answer++;
            }
        }

        return answer;
    }
}
