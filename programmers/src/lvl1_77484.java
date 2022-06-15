public class lvl1_77484 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];

        int zeroCount = 0;
        int winCount = 0;
        for (int i = 0; i < 6; i++) {
            int curNum = lottos[i];
            if (curNum == 0) {
                zeroCount++;
                continue;
            }

            for (int j = 0; j < 6; j++) {
                if (curNum == win_nums[j]) {
                    winCount++;
                }
            }
        }

        answer[0] = getRank(winCount + zeroCount);
        answer[1] = getRank(winCount);

        return answer;
    }

    public int getRank(int num) {
        int result = 0;
        switch (num) {
            case 6:
                result = 1;
                break;
            case 5:
                result = 2;
                break;
            case 4:
                result = 3;
                break;
            case 3:
                result = 4;
                break;
            case 2:
                result = 5;
                break;
            default:
                result = 6;
                break;
        }
        return result;
    }
}
