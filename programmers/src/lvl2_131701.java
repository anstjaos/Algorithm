import java.util.*;

public class lvl2_131701 {
    public int solution(int[] elements) {
        int[] sums = new int[elements.length];
        int sum = 0;
        for (int e : elements) {
            sum += e;
        }

        for (int i = 0; i < elements.length; i++) {
            sums[i] = sum;
        }

        Set<Integer> set = new HashSet<>();
        set.add(sum);

        for (int i = elements.length - 1; i > 0; i--) {
            for (int j = 0; j < elements.length; j++) {
                sums[j] -= elements[(j + i - 1) % elements.length];
                set.add(sums[j]);
            }
        }

        return set.size();
    }
}
