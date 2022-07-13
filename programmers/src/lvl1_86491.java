public class lvl1_86491 {
    public int solution(int[][] sizes) {
        int answer = 0;
        int widthMax = 0, heightMax = 0;
        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] > sizes[i][1]) {
                int temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }

            widthMax = Math.max(widthMax, sizes[i][0]);
            heightMax = Math.max(heightMax, sizes[i][1]);
        }

        answer = widthMax * heightMax;
        return answer;
    }
}
