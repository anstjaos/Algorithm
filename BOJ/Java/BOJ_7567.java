import java.io.*;

public class BOJ_7567 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        br.close();

        int result = 10;
        int len = input.length();
        for (int i = 1; i < len; i++) {
            if (input.charAt(i) != input.charAt(i-1)) result += 10;
            else result += 5;
        }

        System.out.println(result);
    }
}
