import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2502 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        int D = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());

        if (D == 3) {
            System.out.println(1 + "\n" + (K - 1));
            return;
        }

        int[] arr1 = new int[D+1];
        int[] arr2 = new int[D+1];

        arr1[3] = arr2[3] = 1;
        arr1[4] = 1;
        arr2[4] = 2;

        for (int i = 5; i <= D; i++) {
            arr1[i] = arr1[i-1] + arr1[i-2];
            arr2[i] = arr2[i-1] + arr2[i - 2];
        }

        int first = 0;
        int second = 0;

        for (int i = 1;; i++) {
            int res = K - arr1[D] * i;

            if (res % arr2[D] == 0) {
                first = i;
                second = res / arr2[D];
                break;
            }

        }

        System.out.println(first);
        System.out.println(second);
    }
}
