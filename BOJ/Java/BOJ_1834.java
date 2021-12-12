import java.io.*;

public class BOJ_1834 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());
        br.close();

        long result = 0;
        for (long i = 1; i < N; i++) {
            result += (i * N) + i;
        }
        System.out.println(result);
    }
}
