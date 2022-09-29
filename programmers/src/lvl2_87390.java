public class lvl2_87390 {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right - left) + 1];
        int index = 0;
        for(long i = left; i< right + 1; i++){
            answer[index++] = (int) Math.max(i / n,i % n) + 1;
        }
        return answer;
    }
}
