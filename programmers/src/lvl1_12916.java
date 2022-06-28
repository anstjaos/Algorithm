public class lvl1_12916 {
    boolean solution(String s) {
        int pCount = 0, yCount = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);

            if (cur == 'p' || cur == 'P') pCount++;
            else if (cur == 'y' || cur == 'Y') yCount++;
        }

        return pCount == yCount;
    }
}
