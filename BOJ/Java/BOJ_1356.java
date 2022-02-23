import java.io.*;

public class BOJ_1356 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String input = br.readLine();
        br.close();

        int length = input.length();

        boolean isSuccess = false;
        for (int i = 1; i < length; i++) {
            int aNum = 1;
            for (int j = 0; j < i; j++) {
                aNum *= (input.charAt(j) - '0');
            }

            int bNum = 1;
            for (int j = i; j < length; j++) {
                bNum *= (input.charAt(j) - '0');
            }

            if (aNum == bNum) {
                isSuccess = true;
                break;
            }
        }
        System.out.println(isSuccess ? "YES" : "NO");
    }
}
