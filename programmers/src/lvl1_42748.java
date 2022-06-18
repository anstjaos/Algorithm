import java.util.*;

public class lvl1_42748 {
    public int[] solution(int[] array, int[][] commands) {
        int length = commands.length;
        int[] answer = new int[length];

        for (int i = 0; i < length; i++) {
            int from = commands[i][0] - 1;
            int to = commands[i][1];

            int[] temp = new int[to - from];
            for (int j = 0; j < to - from; j++) {
                temp[j] = array[from + j];
            }
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2] -1];
        }
        return answer;
    }
}
