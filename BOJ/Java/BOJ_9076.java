import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_9076 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int tc = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[5];
            for (int i = 0; i < 5; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            if (arr[3] - arr[1] >= 4) sb.append("KIN\n");
            else {
                int sum = 0;
                for (int i = 1; i < 4; i++) sum += arr[i];
                sb.append(sum).append("\n");
            }
        }
        br.close();
        System.out.print(sb);
    }
}
