import java.io.*;

public class BOJ_10988 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String input = br.readLine();
        br.close();

        boolean isPelin = true;

        for (int i = 0; i <= input.length() / 2; i++) {
            char cur = input.charAt(i), end = input.charAt(input.length() - 1 - i);
            if (cur != end) {
                isPelin = false;
                break;
            }
        }

        if (isPelin) System.out.println(1);
        else System.out.println(0);
    }
}
