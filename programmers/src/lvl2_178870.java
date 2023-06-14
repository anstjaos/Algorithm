public class lvl2_178870 {
    public int[] solution(int[] sequence, int k) {
        int start = 0, end = 1, minLength = sequence.length + 1;
        int sum = sequence[0];
        int resultStart = 0, resultEnd = 1;

        while (start < end) {
            if (sequence[start] > k) break;
            if (end > sequence.length) break;

            if (sum < k) {
                if (end == sequence.length) break;
                sum += sequence[end];
                end++;
            } else if (sum > k) {
                sum -= sequence[start];
                start++;
            } else {
                if ((end - start) < minLength) {
                    minLength = end - start;
                    resultStart = start;
                    resultEnd = end;
                }
                sum -= sequence[start];
                start++;
            }
        }
        return new int[]{resultStart, resultEnd - 1};
    }
}
