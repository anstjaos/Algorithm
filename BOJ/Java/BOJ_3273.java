import java.io.*;
import java.util.StringTokenizer;

public class BOJ_3273 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        boolean[] check = new boolean[2000005];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int cur = Integer.parseInt(st.nextToken());
            arr[i] = cur;
            check[cur] = true;
        }

        int x = Integer.parseInt(br.readLine());
        br.close();

        int result = 0;
        for (int i = 0; i < n; i++) {
            if (x - arr[i] >= 0 && check[x - arr[i]]) {
                result++;
            }
        }

        System.out.println(result / 2);
    }
}
