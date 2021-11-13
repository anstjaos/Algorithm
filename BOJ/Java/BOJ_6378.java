import java.io.*;

public class BOJ_6378 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String input = br.readLine();
            if (input.equals("0")) break;

            int length = input.length();
            int sum = 0;
            for (int i = 0; i < length; i++) {
                sum += input.charAt(i) - '0';
            }

            while (sum >= 10) {
                int temp = sum;
                sum = 0;

                while (temp > 0) {
                    sum += temp % 10;
                    temp /= 10;
                }
            }

            sb.append(sum).append("\n");
        }
        br.close();
        System.out.print(sb);
    }
}
