import java.util.*;

public class lvl3_43162 {
    public int solution(int n, int[][] computers) {
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (computers[i][j] == 0) continue;

                join(parent, i, j);
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(getParent(parent, i));
        }

        return set.size();
    }

    private int getParent(int[] parent, int cur) {
        if (parent[cur] == cur) return cur;

        return parent[cur] = getParent(parent, parent[cur]);
    }

    private void join(int[] parent, int a, int b) {
        int aParent = getParent(parent, a);
        int bParent = getParent(parent, b);

        if (aParent < bParent) {
            parent[bParent] = aParent;
        } else {
            parent[aParent] = bParent;
        }
    }
}
