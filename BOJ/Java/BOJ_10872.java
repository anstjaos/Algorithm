import java.io.*;

public class BOJ_10872 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();

        long result = 1;
        for (int i = 2; i<= N; i++) result *= i;

        System.out.println(result);
    }
}
