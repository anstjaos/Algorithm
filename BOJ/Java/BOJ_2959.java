import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2959 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[4];
        for (int i = 0; i < 4; i++) arr[i] = Integer.parseInt(st.nextToken());
        br.close();

        Arrays.sort(arr);
        System.out.println(arr[0] * arr[2]);
    }
}
