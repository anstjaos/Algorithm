public class lvl2_118666 {
    private int[][] score = new int[4][2]; // 0: R T, 1: C F, 2: J M, 3: A N

    public String solution(String[] survey, int[] choices) {

        for (int i = 0; i < choices.length; i++) {
            int num = choices[i] - 4;

            char c = survey[i].charAt(0);
            if (num < 0) {
                num = num * -1;
            } else if (num > 0) {
                c = survey[i]. charAt(1);
            }

            addScore(c, num);
        }
        String answer = "";
        for (int i = 0; i < 4; i++) {
            if (score[i][0] >= score[i][1]) {
                switch (i) {
                    case 0:
                        answer += 'R';
                        break;
                    case 1:
                        answer += 'C';
                        break;
                    case 2:
                        answer += 'J';
                        break;
                    case 3:
                        answer += 'A';
                        break;
                }
            } else {
                switch (i) {
                    case 0:
                        answer += 'T';
                        break;
                    case 1:
                        answer += 'F';
                        break;
                    case 2:
                        answer += 'M';
                        break;
                    case 3:
                        answer += 'N';
                        break;
                }
            }
        }
        return answer;
    }

    private void addScore(char c, int num) {
        switch (c) {
            case 'R':
                score[0][0] += num;
                break;
            case 'T':
                score[0][1] += num;
                break;
            case 'C':
                score[1][0] += num;
                break;
            case 'F':
                score[1][1] += num;
                break;
            case 'J':
                score[2][0] += num;
                break;
            case 'M':
                score[2][1] += num;
                break;
            case 'A':
                score[3][0] += num;
                break;
            case 'N':
                score[3][1] += num;
                break;
        }
    }
}
