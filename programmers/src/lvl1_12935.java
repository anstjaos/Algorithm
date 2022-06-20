public class lvl1_12935 {
    public int[] solution(int[] arr) {
        if (arr.length == 1) {
            int[] result = new int[1];
            result[0] = -1;
            return result;
        }

        int[] answer = new int[arr.length - 1];
        int minNum = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            minNum = Math.min(minNum, arr[i]);
        }

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (minNum == arr[i]) continue;

            answer[count++] = arr[i];
        }
        return answer;
    }
}
