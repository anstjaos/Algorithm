import java.io.*;
import java.util.StringTokenizer;

public class BOJ_5656 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringBuilder sb = new StringBuilder();
        int count = 1;

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            String operator = st.nextToken();
            int num2 = Integer.parseInt(st.nextToken());

            if (operator.equals("E")) break;

            boolean result = false;
            switch (operator) {
                case "<":
                    if (num1 < num2) result = true;
                    break;
                case "<=":
                    if (num1 <= num2) result = true;
                    break;
                case ">":
                    if (num1 > num2) result = true;
                    break;
                case ">=":
                    if (num1 >= num2) result = true;
                    break;
                case "==":
                    if (num1 == num2) result = true;
                    break;
                case "!=":
                    if (num1 != num2) result = true;
                    break;
            }

            sb.append("Case ").append(count).append(": ").append(result).append("\n");
            count++;
        }
        br.close();
        System.out.print(sb);
    }
}
