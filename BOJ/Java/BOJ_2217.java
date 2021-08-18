import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2217 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());
        int[] ropes = new int[N];
        for (int i = 0; i < N; i++) ropes[i] = Integer.parseInt(br.readLine());
        br.close();

        Arrays.sort(ropes);

        int result = 0;
        for (int i = 1; i <= N; i++) {
            result = Math.max(result, ropes[N-i] * i);
        }

        System.out.println(result);
    }
}
