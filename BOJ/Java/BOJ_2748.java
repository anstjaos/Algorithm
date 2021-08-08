import java.io.*;

public class BOJ_2748 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int n = Integer.parseInt(br.readLine());
        long[] fibo = new long[n+5];
        br.close();

        fibo[0] = 0;
        fibo[1] = 1;

        for (int i = 2; i <= n; i++) fibo[i] = fibo[i-1] + fibo[i-2];

        System.out.println(fibo[n]);
    }
}
