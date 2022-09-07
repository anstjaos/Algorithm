public class lvl2_87946 {
    private int maxDungeons = 0;
    private boolean[] isVisit;
    public int solution(int k, int[][] dungeons) {
        isVisit = new boolean[dungeons.length];
        for (int i = 0; i < dungeons.length; i++) {
            if (k < dungeons[i][0]) continue;

            isVisit[i] = true;
            dfs(dungeons, k - dungeons[i][1], 1);
            isVisit[i] = false;
        }
        return maxDungeons;
    }

    private void dfs(int[][] dungeons, int cur, int count) {
        maxDungeons = Math.max(maxDungeons, count);

        for (int i = 0; i < dungeons.length; i++) {
            if (isVisit[i] || cur < dungeons[i][0]) continue;

            isVisit[i] = true;
            dfs(dungeons, cur - dungeons[i][1], count + 1);
            isVisit[i] = false;
        }
    }
}
