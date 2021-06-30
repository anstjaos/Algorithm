import java.io.*;
import java.util.Arrays;

public class BOJ_2295 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());
        br.close();

        Arrays.sort(arr);
        int result = 0;
        for (int i = N - 1; i >= 0; i--) {
            int target = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                int x = arr[j];

                for (int k = i - 1; k >= 0; k--) {
                    int y = arr[k];

                    if (x + y >= target) continue;

                    for (int t = i - 1; t >= 0; t--) {
                        int z = arr[t];
                        if (x + y + z == target) {

                            System.out.println(target);
                            return;
                        }
                    }
                }
            }
        }

    }
}
