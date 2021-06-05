import java.io.*;
import java.util.Arrays;

public class BOJ_2485 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());
        br.close();

        Arrays.sort(arr);
        int[] diff = new int[N-1];
        for (int i = 1; i < N; i++) diff[i-1] = arr[i] - arr[i-1];

        int gcd = getGCD(diff[0], diff[1]);
        for (int i = 2; i < N - 1; i++) {
            gcd = getGCD(gcd, diff[i]);
        }

        int result = 0;
        for (int i = 0; i < N - 1; i++) {
            int num = arr[i+1] - arr[i];
            result += (num / gcd) - 1;
        }

        System.out.println(result);
    }

    private static int getGCD(int a, int b) {
        while (b != 0) {
            int c = a % b;
            a = b;
            b = c;
        }
        return a;
    }
}
