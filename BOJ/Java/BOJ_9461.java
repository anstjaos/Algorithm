import java.io.*;

public class BOJ_9461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] triangle = new long[105];
        triangle[1] = triangle[2] = triangle[3] = 1;
        triangle[4] = triangle[5] = 2;

        for (int i = 6; i <= 100; i++) {
            triangle[i] = triangle[i-1] + triangle[i-5];
        }

        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
            int num = Integer.parseInt(br.readLine());
            sb.append(triangle[num]).append("\n");
        }

        System.out.print(sb);
        br.close();
    }
}
