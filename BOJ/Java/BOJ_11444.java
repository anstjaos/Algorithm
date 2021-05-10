import java.io.*;

public class BOJ_11444 {
    private static final int MOD = 1000000007;
    private static long[][] arr = {{1, 1}, {1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        br.close();

        long result = 0;
        if (n == 1) result = 1;
        else if (n > 1) {
            long[][] res = fibo(n-1);
            result = res[0][0];
        }

        System.out.println(result);
    }

    private static long[][] fibo(long n) {
        long[][] temp = new long[2][2];

        if (n == 1) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) temp[i][j] = arr[i][j];
            }

            return temp;
        }

        long[][] result;
        result = fibo(n / 2);

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    temp[i][j] += result[i][k] * result[k][j];
                }
                temp[i][j] %= MOD;
            }
        }

        if ((n & 1) == 1) {
            long[][] t = new long[2][2];
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    for (int k = 0; k < 2; k++) {
                        t[i][j] += temp[i][k] * arr[k][j];
                    }
                    t[i][j] %= MOD;
                }
            }
            return t;
        }
        return temp;
    }
}
