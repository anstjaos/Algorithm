public class lvl1_1845 {
    public int solution(int[] nums) {
        int answer = 0;
        boolean[] isSelected = new boolean[200005];
        for (int i = 0; i < nums.length; i++) {
            if (!isSelected[nums[i]]) {
                answer++;
                isSelected[nums[i]] = true;
            }
        }

        answer = Math.min(answer, nums.length / 2);
        return answer;
    }
}
