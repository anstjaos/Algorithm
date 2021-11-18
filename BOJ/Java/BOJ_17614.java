import java.io.*;

public class BOJ_17614 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());
        br.close();

        int clapCount = 0;
        for (int i = 1; i <= N; i++) {
            int temp = i;
            while (temp > 0) {
                int val = temp % 10;
                if (val != 0 && val % 3 == 0) clapCount++;
                temp /= 10;
            }
        }

        System.out.println(clapCount);
    }
}
