public class lvl1_12929 {
    public String solution(String[] seoul) {
        String result = "";
        int index = 0;
        for (int i = 0; i < seoul.length; i++) {
            if (seoul[i].equals("Kim")) {
                index = i;
                break;
            }
        }
        result = "김서방은 " + index + "에 있다";
        return result;
    }
}
