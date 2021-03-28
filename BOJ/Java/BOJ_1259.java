import java.io.*;

public class BOJ_1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            String input = br.readLine();
            if (input.equals("0")) break;

            int len = input.length();
            int start = 0, end = len -1;

            boolean isPelindrom = true;
            while (start < end) {
                if (input.charAt(start) != input.charAt(end)) {
                    isPelindrom = false;
                    break;
                }

                start++;
                end--;
            }

            if (isPelindrom) sb.append("yes\n");
            else sb.append("no\n");
        }

        System.out.print(sb.toString());
        br.close();
    }
}
