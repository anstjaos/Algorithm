public class lvl1_12917 {
    public String solution(String s) {
        int[] count = new int[52];
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);

            if ('a' <= cur && cur <= 'z') {
                count[cur - 'a']++;
            } else {
                count[cur - 'A' + 26]++;
            }
        }
        String answer = "";
        for (int i = 25; i >= 0; i--) {
            while (count[i] != 0) {
                answer += (char) ('a' + i);
                count[i]--;
            }
        }
        for (int i = 51; i >= 26; i--) {
            while (count[i] != 0) {
                answer += (char) ('A' + i - 26);
                count[i]--;
            }
        }
        return answer;
    }
}
