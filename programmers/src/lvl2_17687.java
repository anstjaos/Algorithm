import java.util.*;

public class lvl2_17687 {
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        String[] values = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};

        p--;
        int curIndex = 0;
        int num = 0;

        while (true) {
            int temp = num;

            List<String> arr = new ArrayList<>();
            while (temp > 0) {
                arr.add(values[temp % n]);
                temp /= n;
            }

            if (num == 0) {
                arr.add("0");
            }

            boolean isSuccess = false;
            for (int i = arr.size() - 1; i >= 0; i--) {
                if (curIndex == p) {
                    answer.append(arr.get(i));
                    if (answer.length() == t) {
                        isSuccess = true;
                        break;
                    }
                }
                curIndex = (curIndex + 1) % m;
            }

            if (isSuccess) break;
            num++;
        }

        return answer.toString();
    }
}
