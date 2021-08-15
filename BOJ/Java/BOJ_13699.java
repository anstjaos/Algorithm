import java.io.*;

public class BOJ_13699 {
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int n = Integer.parseInt(br.readLine());
        br.close();

        long[] arr = new long[n + 5];
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 2;

        for (int i = 3; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                arr[i] += (arr[j] * arr[i - 1 - j]);
            }
        }

        System.out.println(arr[n]);
    }
}
