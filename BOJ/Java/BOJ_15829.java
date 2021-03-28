import java.io.*;

public class BOJ_15829 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        String input = br.readLine();

        long r = 1;
        long sum = 0;
        for (int i = 0; i < L; i++) {
            sum = (sum + ((input.charAt(i) - 'a' + 1) * r % 1234567891)) % 1234567891;
            r *= 31;
            r %= 1234567891;
        }

        System.out.println(sum);
        br.close();
    }
}
