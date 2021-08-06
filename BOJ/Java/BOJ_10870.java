import java.io.*;

public class BOJ_10870 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());
        br.close();

        int[] arr = new int[N+5];
        arr[0] = 0;
        arr[1] = 1;

        for (int i = 2; i <= N; i++) arr[i] = arr[i-1] + arr[i-2];

        System.out.println(arr[N]);
    }
}
