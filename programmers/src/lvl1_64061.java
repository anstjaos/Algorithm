public class lvl1_64061 {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int depth = board.length;
        int width = board[0].length;

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < width + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = depth - 1; i >= 0; i--) {
            for (int j = 0; j < width; j++) {
                if (board[i][j] != 0) {
                    list.get(j + 1).add(board[i][j]);
                }
            }
        }

        int[] lengthArr = new int[width + 1];
        for (int i = 1; i <= width; i++) {
            lengthArr[i] = list.get(i).size();
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < moves.length; i++) {
            int cur = moves[i];
            List<Integer> curList = list.get(cur);

            int end = lengthArr[cur];
            if (end != 0) {
                int endItem = curList.get(end - 1);
                lengthArr[cur]--;

                if (!stack.empty() && stack.peek() == endItem) {
                    answer += 2;
                    stack.pop();
                } else {
                    stack.push(endItem);

                }
            }
        }
        return answer;
    }
}

