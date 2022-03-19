import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2548 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        Arrays.sort(arr);
        int min = Integer.MAX_VALUE, result = 0;
        for (int i = 0; i < N; i++) {
            int temp = 0;
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                temp += Math.abs(arr[i] - arr[j]);
            }
            if (min > temp) {
                min = temp;
                result = arr[i];
            }
        }

        System.out.println(result);
    }
}
