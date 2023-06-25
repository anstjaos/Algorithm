public class lvl3_64062 {
    public int solution(int[] stones, int k) {
        int min = 0, max = Integer.MAX_VALUE;
        int answer = 0;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (canCrossBridge(mid, k, stones)) {
                min = mid + 1;
                answer = mid;
            } else {
                max = mid - 1;
            }
        }
        return answer;
    }

    private boolean canCrossBridge(int mid, int k, int[] stones) {
        int count = 0;
        for (int stone : stones) {
            if (stone < mid) {
                count++;
                if (count == k) {
                    return false;
                }
            } else {
                count = 0;
            }
        }

        return true;
    }
}
