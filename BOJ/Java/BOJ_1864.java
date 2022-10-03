import java.io.*;

public class BOJ_1864 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        StringBuilder sb = new StringBuilder();
        while (true) {
            String input = br.readLine();
            if (input.equals("#")) break;

            int num = 1;
            int length = input.length();
            int sum = 0;
            for (int i = length - 1; i >= 0; i--) {
                char cur = input.charAt(i);

                switch (cur) {
                    case '-':
                        break;
                    case '\\':
                        sum += num;
                        break;
                    case '(':
                        sum += num * 2;
                        break;
                    case '@':
                        sum += num * 3;
                        break;
                    case '?':
                        sum += num * 4;
                        break;
                    case '>':
                        sum += num * 5;
                        break;
                    case '&':
                        sum += num * 6;
                        break;
                    case '%':
                        sum += num * 7;
                        break;
                    case '/':
                        sum += num * -1;
                        break;
                }
                num *= 8;
            }
            sb.append(sum).append("\n");
        }
        br.close();
        System.out.print(sb);
    }
}
