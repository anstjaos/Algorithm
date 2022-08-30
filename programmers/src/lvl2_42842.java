public class lvl2_42842 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int row = 0, col = 0;
        for (int i = 1; i <= yellow; i++) {
            if (yellow % i != 0) continue;

            int result = getBrown(i, yellow / i);
            if (result == brown) {
                row = yellow / i + 2;
                col = i + 2;
                break;
            }
        }
        answer[0] = row;
        answer[1] = col;
        return answer;
    }

    private int getBrown(int row, int col) {
        return ((row + 2) * 2) + (col * 2);
    }
}
