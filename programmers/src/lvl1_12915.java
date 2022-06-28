import java.util.*;

public class lvl1_12915 {
    public String[] solution(String[] strings, int n) {
        List<String> list = Arrays.asList(strings);

        list.sort((a, b) -> {
            if (a.charAt(n) == b.charAt(n)) {
                return a.compareTo(b);
            }

            return a.charAt(n) - b.charAt(n);
        });
        return list.toArray(new String[0]);
    }
}
