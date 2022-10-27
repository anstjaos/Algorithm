import java.io.*;

public class BOJ_23037 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int n = Integer.parseInt(br.readLine());

        int sum = 0;
        while (n != 0) {
            int num = n % 10;
            n /= 10;

            sum += Math.pow(num, 5);
        }
        br.close();
        System.out.println(sum);
    }
}
