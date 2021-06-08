import java.io.*;

public class BOJ_2747 {
    private static long[] fibo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        fibo = new long[50];
        fibo[0] = 0;
        fibo[1] = 1;
        fibo[2] = 1;

        int n = Integer.parseInt(br.readLine());
        System.out.println(getNthFibo(n));
        br.close();
    }

    private static long getNthFibo(int n) {
        if (n <= 2) return fibo[n];
        if (fibo[n] != 0) return fibo[n];

        fibo[n] = getNthFibo(n-1) + getNthFibo(n-2);
        return fibo[n];
    }
}
