public class lvl2_17679 {
    public int solution(int m, int n, String[] board) {
        int answer = 0;

        while (true) {
            boolean[][] isBreak = new boolean[board.length][board[0].length()];

            for (int i = 0; i < board.length - 1; i++) {
                for (int j = 0; j < board[0].length() - 1; j++) {
                    char c = board[i].charAt(j);
                    if (c == '.') continue;

                    if (c == board[i].charAt(j + 1) && c == board[i + 1].charAt(j + 1) && c == board[i + 1].charAt(j)) {
                        isBreak[i][j] = true;
                        isBreak[i][j + 1] = true;
                        isBreak[i + 1][j + 1] = true;
                        isBreak[i + 1][j] = true;
                    }
                }
            }

            int count = 0;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length(); j++) {
                    if (isBreak[i][j]) {
                        count++;
                    }
                }
            }
            if (count == 0) break;
            answer += count;

            String[] temp = new String[board.length];
            for (int i = board.length - 1; i >= 0; i--) {
                StringBuilder sb = new StringBuilder();

                for (int j = 0; j < board[0].length(); j++) {
                    if (!isBreak[i][j]) {
                        sb.append(board[i].charAt(j));
                    } else {
                        int k = i - 1;
                        for (; k >= 0; k--) {
                            if (!isBreak[k][j]) break;
                        }

                        if (k == -1) sb.append('.');
                        else {
                            isBreak[k][j] = true;
                            sb.append(board[k].charAt(j));
                        }
                    }
                }

                temp[i] = sb.toString();
            }

            board = temp;
        }
        return answer;
    }
}
