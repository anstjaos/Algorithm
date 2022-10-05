import java.io.*;

public class BOJ_9713 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int[] sum = new int[105];
        sum[1] = 1;
        for (int i = 2; i < 105; i++) {
            if (i % 2 == 1) {
                sum[i] = sum[i - 2] + i;
            } else {
                sum[i] = sum[i - 1];
            }
        }

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int num = Integer.parseInt(br.readLine());
            sb.append(sum[num]).append("\n");
        }
        br.close();
        System.out.print(sb);
    }
}
