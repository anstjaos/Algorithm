import java.io.*;

public class BOJ_3062 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            String input = br.readLine();
            String reverse = new StringBuilder(input).reverse().toString();

            int sum = Integer.parseInt(input) + Integer.parseInt(reverse);
            String result = String.valueOf(sum);

            int length = result.length();
            boolean isPelindrom = true;
            for (int i = 0; i <= length / 2; i++) {
                if (result.charAt(i) != result.charAt(length - 1 - i)) {
                    isPelindrom = false;
                    break;
                }
            }

            if (isPelindrom) sb.append("YES\n");
            else sb.append("NO\n");
        }
        br.close();
        System.out.print(sb);
    }
}
