public class lvl1_12918 {
    public boolean solution(String s) {
        int length = s.length();
        if (length != 4 && length != 6) {
            return false;
        }

        for (int i = 0; i < length; i++) {
            char cur = s.charAt(i);

            if (!('0' <= cur && cur <= '9')) {
                return false;
            }
        }
        return true;
    }
}
