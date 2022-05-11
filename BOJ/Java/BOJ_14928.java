import java.io.*;

public class BOJ_14928 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String input = br.readLine();
        int length = input.length();

        long temp = 0;
        for (int i = 0; i < length; i++) {
            temp = (temp * 10 + (input.charAt(i) - '0')) % 20000303;
        }
        br.close();

        System.out.println(temp);
    }
}
