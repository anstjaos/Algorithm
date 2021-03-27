import java.io.*;

public class BOJ_3052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[50];

        for (int i = 0 ; i < 10; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[num % 42]++;
        }

        int result = 0;
        for (int i = 0 ; i < 42; i++) {
            if (arr[i] > 0) result++;
        }

        System.out.println(result);
        br.close();
    }
}
