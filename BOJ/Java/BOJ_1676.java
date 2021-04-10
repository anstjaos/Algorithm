import java.io.*;

public class BOJ_1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int count = 0;

        while (num >= 5) {
            count += num / 5;
            num /= 5;
        }

        System.out.println(count);
        br.close();
    }
}
