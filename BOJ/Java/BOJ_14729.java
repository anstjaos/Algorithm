import java.io.*;
import java.util.Arrays;

public class BOJ_14729 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());
        float[] arr = new float[N];

        for (int i = 0; i < N; i++) arr[i] = Float.parseFloat(br.readLine());
        br.close();

        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 7; i++) sb.append(String.format("%.3f", arr[i])).append("\n");

        System.out.print(sb);
    }
}
