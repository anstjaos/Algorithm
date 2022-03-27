import java.io.*;

public class BOJ_1731 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        boolean isAsc = false;
        int diff = 0;
        if (arr[2] - arr[1] == arr[1] - arr[0]) {
            isAsc = true;
            diff = arr[1] - arr[0];
        } else {
            diff = arr[2] / arr[1];
        }

        System.out.println(isAsc ? arr[N-1] + diff : arr[N-1] * diff);
    }
}
