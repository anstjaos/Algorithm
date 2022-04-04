import java.io.*;

public class BOJ_14916 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int n = Integer.parseInt(br.readLine());
        br.close();

        int result = -1;
        int fiveCnt = n / 5;
        for (int i = fiveCnt; i >= 0; i--) {
            int temp = n - (i * 5);
            if (temp == 0) {
                result = i;
                break;
            }

            if (temp % 2 == 0) {
                result = i + (temp / 2);
                break;
            }
        }

        System.out.println(result);
    }
}
