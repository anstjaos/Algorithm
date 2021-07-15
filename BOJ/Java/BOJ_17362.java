import java.io.*;

public class BOJ_17362 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();

        if (n <= 5) {
            System.out.println(n);
            return;
        }

        n--;
        if (n % 4 == 0) {
            if (((n /4) % 2) == 0) {
                System.out.println(1);
            } else {
                System.out.println(5);
            }
        } else {
            if (((n /4) % 2) == 0) {
                System.out.println(1 + (n % 4));
            } else {
                System.out.println(5 - (n % 4));
            }
        }
    }
}
