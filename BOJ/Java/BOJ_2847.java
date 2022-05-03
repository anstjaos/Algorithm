import java.io.*;

public class BOJ_2847 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int result = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int before = arr[N-1];
        for (int i = N - 2; i >= 0; i--) {
            if (arr[i] >= before) {
                result += (arr[i] - (before - 1));
                arr[i] = (before-1);
            }
            before = arr[i];
        }
        br.close();
        System.out.println(result);
    }
}
