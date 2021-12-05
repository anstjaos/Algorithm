import java.io.*;

public class BOJ_1964 {
    private static final int DIV = 45678;
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());
        br.close();

        int[] arr = new int[N + 1];
        arr[1] = 5;
        for (int i = 2; i <= N; i++) {
            arr[i] = (arr[i-1] + (3 * i + 1)) % DIV;
        }

        System.out.println(arr[N]);
    }
}
