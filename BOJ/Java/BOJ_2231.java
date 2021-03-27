import java.io.*;

public class BOJ_2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int sum = 0;
        for (int i = 1; i < N; i++) {
            sum = i;

            int temp = i;
            while (temp != 0) {
                sum += temp % 10;
                temp /= 10;
            }

            if (sum == N) {
                System.out.println(i);
                return;
            }
        }
        System.out.println("0");
        br.close();
    }
}
