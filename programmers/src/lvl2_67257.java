import java.util.*;

public class lvl2_67257 {
    private String[][] oper = {{ "+", "-", "*" }, { "+", "*", "-" }, { "-", "*", "+" },
            { "-", "+", "*" }, { "*", "-", "+" }, { "*", "+", "-" }};

    public long solution(String expression) {
        long answer = -1;

        List<String> expList = new ArrayList<>();
        int start = 0;
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*') {
                expList.add(expression.substring(start, i));
                expList.add(expression.charAt(i) + "");
                start = i + 1;
            }
        }
        expList.add(expression.substring(start));

        for (String[] strings : oper) {
            List<String> temp = new ArrayList<>(expList);
            for (int k = 0; k < 3; k++) {
                for (int j = 0; j < temp.size(); j++) {
                    if (strings[k].equals(temp.get(j))) {
                        temp.set(j - 1, calc(temp.get(j - 1), temp.get(j), temp.get(j + 1)));
                        temp.remove(j);
                        temp.remove(j);
                        j--;
                    }
                }
            }

            answer = Math.max(answer, Math.abs(Long.parseLong(temp.get(0))));
        }
        return answer;
    }

    private String calc(String num1, String op, String num2) {
        long n1 = Long.parseLong(num1);
        long n2 = Long.parseLong(num2);

        if (op.equals("+"))
            return n1 + n2 + "";
        else if (op.equals("-"))
            return n1 - n2 + "";

        return n1 * n2 + "";
    }
}
