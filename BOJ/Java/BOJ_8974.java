import java.io.*;
import java.util.StringTokenizer;

public class BOJ_8974 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());
        br.close();

        int[] arr = new int[B+5];

        int num = 1, count = 1, idx = 1;
        while (idx <= B) {
            arr[idx++] = num;
            count--;

            if (count == 0) {
                num++;
                count = num;
            }
        }

        int sum = 0;
        for (int i = A; i <= B; i++) {
            sum += arr[i];
        }
        System.out.println(sum);
    }
}
