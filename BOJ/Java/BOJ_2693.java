import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2693 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr;
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
            arr = new int[10];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 10; i++) arr[i] = Integer.parseInt(st.nextToken());

            Arrays.sort(arr);
            sb.append(arr[7]).append("\n");
        }
        br.close();
        System.out.print(sb);
    }
}
