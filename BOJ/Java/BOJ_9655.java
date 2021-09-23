import java.io.*;

public class BOJ_9655 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());
        br.close();

        int[] arr = new int[N+1];
        arr[N] = 1;
        for (int i = N; i > 0; i--) {
            arr[i - 1] = arr[i] * -1;
            if (i - 3 >= 0) arr[i - 3] = arr[i] * -1;
        }

        if (arr[0] == -1) System.out.println("SK");
        else System.out.println("CY");
    }
}
