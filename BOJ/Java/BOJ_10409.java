import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10409 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()), T = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        br.close();

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (T - arr[i] < 0) break;

            T -= arr[i];
            count++;
        }

        System.out.println(count);
    }
}
