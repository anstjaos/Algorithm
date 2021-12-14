import java.io.*;

public class BOJ_10174 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            String input = br.readLine();
            int length = input.length();

            boolean isPelindrom = true;
            for (int i = 0; i <= length / 2; i++) {
                char cur = input.charAt(i);
                char end = input.charAt(length - i - 1);

                if ('A' <= cur && cur <= 'Z') cur = (char) (cur - 'A' + 'a');
                if ('A' <= end && end <= 'Z') end = (char) (end - 'A' + 'a');

                if (cur != end) {
                    isPelindrom = false;
                    break;
                }
            }
            sb.append(isPelindrom ? "Yes" : "No").append("\n");
        }
        br.close();
        System.out.print(sb);
    }
}
