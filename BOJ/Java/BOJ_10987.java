import java.io.*;

public class BOJ_10987 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String input = br.readLine();

        int length = input.length();
        int result = 0;

        for (int i = 0; i < length; i++) {
            char cur = input.charAt(i);
            if (cur == 'a' || cur == 'e' || cur == 'i' || cur == 'o' || cur == 'u') result++;
        }
        br.close();
        System.out.println(result);
    }
}
