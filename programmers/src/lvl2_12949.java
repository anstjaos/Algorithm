public class lvl2_12949 {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int arr1Row = arr1.length, arr1Col = arr1[0].length;
        int arr2Row = arr2.length, arr2Col = arr2[0].length;
        int[][] answer = new int[arr1Row][arr2Col];

        for (int i = 0; i < arr1Row; i++) {
            for (int j = 0; j < arr2Col; j++) {
                for (int k = 0; k < arr2Row; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return answer;
    }
}
