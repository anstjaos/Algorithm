import java.io.*;

public class BOJ_4892 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        StringBuilder sb = new StringBuilder();
        for (int i = 1;; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) break;

            int num1 = 3 * num;
            String numStr = "";
            if (num1 % 2 == 0) numStr = "even";
            else numStr = "odd";

            int num4 = 0;
            if (num % 2 == 0) num4 = num / 2;
            else num4 = (num - 1) / 2;

            sb.append(i).append(". ").append(numStr).append(" ").append(num4).append("\n");
        }
        br.close();

        System.out.print(sb);
    }
}
