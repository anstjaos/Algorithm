import java.io.*;

public class BOJ_10998 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int A = input.charAt(0) - '0';
        int B = input.charAt(2) - '0';

        System.out.println(A * B);
        br.close();
    }
}
