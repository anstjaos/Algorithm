import java.io.*;

public class BOJ_1212 {
    private static String[] firstOcta = {"0", "1", "10", "11", "100", "101", "110", "111"};
    private static String[] octa = {"000", "001", "010", "011", "100", "101", "110", "111"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        br.close();
        int len = input.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int num = input.charAt(i) - '0';

            if (i == 0) sb.append(firstOcta[num]);
            else sb.append(octa[num]);
        }

        System.out.println(sb);
    }
}
