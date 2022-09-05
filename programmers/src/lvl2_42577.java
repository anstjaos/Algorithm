import java.util.*;

public class lvl2_42577 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Map<String, Integer> phoneBook = new HashMap<>();
        for (int i = 0; i < phone_book.length; i++) {
            phoneBook.put(phone_book[i], i);
        }

        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 0; j < phone_book[i].length(); j++) {
                if (phoneBook.containsKey(phone_book[i].substring(0, j))) {
                    answer = false;
                    break;
                }
            }
        }
        return answer;
    }
}
