import java.io.*;

public class BOJ_6679 {
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        StringBuilder sb = new StringBuilder();
//        br.close();
        for (int i = 1000; i < 10000; i++) {
            int temp = i;
            int sum10 = 0;
            while (temp != 0) {
                sum10 += temp % 10;
                temp /= 10;
            }

            temp = i;
            int sum12 = 0;
            while (temp != 0) {
                sum12 += temp % 12;
                temp /= 12;
            }

            if (sum10 != sum12) continue;

            temp = i;
            int sum16 = 0;
            while (temp != 0) {
                sum16 += temp % 16;
                temp /= 16;
            }

            if (sum10 == sum16) sb.append(i).append("\n");
        }

        System.out.print(sb);
    }
}
