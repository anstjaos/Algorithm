import java.io.*;

public class BOJ_1094 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        br.close();

        int count = 1, min = 64, sum = 64;
        while (sum != X) {
            int temp = sum - (min / 2);
            count += 1;
            if (temp >= X) {
                sum -= (min / 2);
                count--;
            }
            min = min / 2;
        }
        System.out.println(count);
    }
}
