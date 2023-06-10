public class lvl2_68936 {
    int zeroCount = 0;
    int oneCount = 0;
    public int[] solution(int[][] arr) {
        int size = arr.length;
        compress(0, 0, size, arr);

        return new int[]{zeroCount, oneCount};
    }

    private void compress(int curX, int curY, int size, int[][] arr) {
        if (size == 1) {
            if (arr[curX][curY] == 0) zeroCount++;
            else oneCount++;
            return;
        }

        int num = arr[curX][curY];
        boolean isSame = true;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (num != arr[curX + i][curY + j]) {
                    isSame = false;
                    break;
                }
            }
            if (!isSame) break;
        }

        if (isSame) {
            if (num == 0) zeroCount++;
            else oneCount++;
            return;
        }

        compress(curX, curY, size / 2, arr);
        compress(curX + size / 2, curY, size / 2, arr);
        compress(curX, curY + size / 2, size / 2, arr);
        compress(curX + size / 2, curY + size / 2, size / 2, arr);
    }
}
