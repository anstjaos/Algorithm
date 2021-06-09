import java.io.*;

public class BOJ_1550 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        br.close();

        int len = input.length();
        long result = 0;
        for (int i = len - 1; i >= 0; i--) {
            int num = getNum(input.charAt(i));
            result += num * Math.pow(16, len - 1 - i);
        }
        System.out.println(result);
    }

    private static int getNum(char c) {
        if ('0' <= c && c <= '9') return c - '0';
        else return c - 'A' + 10;
    }
}
