import java.io.*;

public class BOJ_11104 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            String input = br.readLine();

            int num = 0;
            int binary = 1;

            for (int i = 23; i >= 0; i--) {
                num += (input.charAt(i) - '0') * binary;
                binary *= 2;
            }
            sb.append(num).append("\n");
        }
        br.close();
        System.out.print(sb);
    }
}
