import java.io.*;

public class BOJ_1075 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine()), F = Integer.parseInt(br.readLine());
        br.close();

        int result = 0;
        for (int i = 0; i < 100; i++) {
            int temp = (N / 100) * 100 + i;
            if (temp % F == 0) {
                result = i;
                break;
            }
        }

        System.out.printf("%02d%n", result);
    }
}
