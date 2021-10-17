import java.io.*;
import java.util.Arrays;

public class BOJ_5052 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] numbers = new String[n];

            for (int i = 0; i < n; i++) numbers[i] = br.readLine();
            Arrays.sort(numbers);

            boolean isSame = true;
            for (int i = 0; i < n - 1; i++) {
                if (numbers[i + 1].startsWith(numbers[i])) {
                    isSame = false;
                    break;
                }
            }

            if (isSame) sb.append("YES\n");
            else sb.append("NO\n");
        }
        br.close();
        System.out.print(sb);
    }
}
