import java.io.*;

public class BOJ_10039 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            int num = Integer.parseInt(br.readLine());
            num = Math.max(num, 40);
            sum += num;
        }
        br.close();
        System.out.println(sum / 5);
    }
}
