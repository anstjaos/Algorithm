import java.io.*;

public class BOJ_11726 {
    private static final int MOD = 10007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[1001];
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i < 1001; i++) {
            arr[i] = arr[i-1] + arr[i-2];
            arr[i] %= MOD;
        }

        int n = Integer.parseInt(br.readLine());
        System.out.println(arr[n]);
        br.close();
    }
}
