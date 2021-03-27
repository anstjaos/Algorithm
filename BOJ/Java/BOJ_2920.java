import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[10];
        for (int i =0; i < 8; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean isAscending = false, isDescending = false;

        if (arr[0] == 1) isAscending = true;
        if (arr[0] == 8) isDescending = true;

        if (!isAscending && !isDescending) {
            System.out.println("mixed");
            return;
        }

        if (isAscending) {
            for (int i = 1; i < 8; i++) {
                if (arr[i] - arr[i-1] != 1) {
                    isAscending = false;
                    break;
                }
            }
        } else {
            for (int i = 1; i < 8; i++) {
                if (arr[i] - arr[i-1] != -1) {
                    isDescending = false;
                    break;
                }
            }
        }

        if (isAscending) {
            System.out.println("ascending");
        } else if (isDescending) {
            System.out.println("descending");
        } else {
            System.out.println("mixed");
        }
        br.close();
    }
}
