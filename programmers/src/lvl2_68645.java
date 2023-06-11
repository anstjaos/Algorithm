public class lvl2_68645 {
    public int[] solution(int n) {
        int[][] arr = new int[n][n];

        int x = -1, y = 0;
        int num = 1;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i % 3 == 0) {
                    x++;
                } else if (i % 3 == 1) {
                    y++;
                } else {
                    x--;
                    y--;
                }
                arr[x][y] = num++;
            }
        }

        int[] answer = new int[n * (n + 1) / 2];

        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n ; j++) {
                if (arr[i][j] == 0) continue;
                answer[index] = arr[i][j];
                index++;
            }
        }
        return answer;
    }
}
