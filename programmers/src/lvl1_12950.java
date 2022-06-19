public class lvl1_12950 {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int rowCount = arr1.length;
        int colCount = arr1[0].length;

        int[][] answer = new int[rowCount][colCount];
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        return answer;
    }
}
