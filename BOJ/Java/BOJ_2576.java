import java.io.*;

public class BOJ_2576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0, minVal = Integer.MAX_VALUE;
        for (int i = 0; i < 7; i++) {
            int num = Integer.parseInt(br.readLine());
            if ((num & 1) == 1) {
                sum += num;
                minVal = Math.min(minVal, num);
            }
        }
        br.close();

        if (sum == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(minVal);
        }
    }
}
