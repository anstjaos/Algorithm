import java.io.*;

public class BOJ_17618 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());
        br.close();

        int result = 0;
        for (int i = 1; i <= N; i++) {
            int sum = 0, temp = i;
            while (temp != 0) {
                sum += (temp % 10);
                temp /= 10;
            }

            if (i % sum == 0) result++;
        }

        System.out.println(result);
    }
}
