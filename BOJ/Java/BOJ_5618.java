import java.io.*;
import java.util.StringTokenizer;

public class BOJ_5618 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int maxNum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            maxNum = Math.max(maxNum, num);
            arr[i] = num;
        }
        br.close();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= maxNum; i++) {
            boolean isSame = true;
            for (int j = 0; j < n; j++) {
                if (arr[j] % i != 0) {
                    isSame = false;
                    break;
                }
            }

            if (isSame) sb.append(i).append("\n");
        }

        System.out.print(sb);
    }
}
