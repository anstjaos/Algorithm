import java.io.*;

public class BOJ_1871 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            String input = br.readLine();
            int result = 0;

            for (int i = 0; i < 3; i++) {
                result += ((int) (input.charAt(i) - 'A') * Math.pow(26, 2 - i));
            }
            result -= Integer.parseInt(input.substring(4, 8));

            if (Math.abs(result) <= 100) sb.append("nice\n");
            else sb.append("not nice\n");
        }
        br.close();
        System.out.print(sb);
    }
}
