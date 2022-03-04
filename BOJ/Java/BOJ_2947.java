import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2947 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        StringBuilder sb = new StringBuilder();

        while (true) {
            for (int i = 0; i < 4; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;

                    for (int j = 0; j < 5; j++) {
                        sb.append(arr[j] + " ");
                    }
                    sb.append("\n");
                }
            }

            boolean isExit = true;
            for (int i = 0; i < 4; i++) {
                if (arr[i] > arr[i + 1]) {
                    isExit = false;
                    break;
                }
            }

            if (isExit) break;
        }

        System.out.print(sb);
    }
}
