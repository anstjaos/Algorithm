import java.io.*;

public class BOJ_9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] count = new int[15];
        count[1] = 1;
        count[2] = 2;
        count[3] = 4;

        for (int i = 4; i < 15; i++) {
            count[i] = count[i-1] + count[i-2] + count[i-3];
        }

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            sb.append(count[num]).append("\n");
        }

        System.out.print(sb);
        br.close();
    }
}
