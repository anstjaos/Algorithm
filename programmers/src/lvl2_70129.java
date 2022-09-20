public class lvl2_70129 {
    public int[] solution(String s) {
        int count = 0, removeZeroCount = 0;

        while (s.length() != 1) {
            int tempZeroCount = 0;

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') tempZeroCount++;
            }
            removeZeroCount += tempZeroCount;

            int length = s.length() - tempZeroCount;

            StringBuilder temp = new StringBuilder();
            while (length != 0) {
                temp.append(length % 2);
                length /= 2;
            }
            s = temp.reverse().toString();

            count++;
        }
        int[] answer = new int[2];
        answer[0] = count;
        answer[1] = removeZeroCount;
        return answer;
    }
}
