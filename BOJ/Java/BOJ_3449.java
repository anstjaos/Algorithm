import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_3449 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
            String num1 = br.readLine();
            String num2 = br.readLine();

            int len = num1.length();
            int diffCount = 0;
            for (int i = 0; i < len; i++) {
                if (num1.charAt(i) != num2.charAt(i)) diffCount++;
            }

            sb.append("Hamming distance is ").append(diffCount).append(".\n");
        }
        br.close();
        System.out.print(sb);
    }
}
