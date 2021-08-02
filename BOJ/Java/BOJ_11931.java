import java.io.*;
import java.util.Arrays;

public class BOJ_11931 {
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());
        br.close();

        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for (int i = N - 1; i >= 0; i--) sb.append(arr[i]).append("\n");

        System.out.print(sb);
    }
}
