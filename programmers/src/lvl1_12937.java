public class lvl1_12937 {
    public String solution(int num) {
        String answer = "";
        if ((num & 1) == 1) {
            answer = "Odd";
        } else {
            answer = "Even";
        }
        return answer;
    }
}
