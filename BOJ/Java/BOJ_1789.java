import java.io.*;

public class BOJ_1789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(br.readLine());
        br.close();

        long count = 0;
        long sum = 0;
        while (sum < S) {
            count++;
            sum += count;
        }

        if (sum > S) count--;

        System.out.println(count);
    }
}
