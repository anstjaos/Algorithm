import java.io.*;

public class BOJ_13235 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String input = br.readLine();
        br.close();

        int length = input.length();
        boolean result = true;
        for (int i = 0; i <= length / 2; i++) {
            if (input.charAt(i) != input.charAt(length - 1 - i)) {
                result = false;
                break;
            }
        }

        System.out.println(result);
    }
}
