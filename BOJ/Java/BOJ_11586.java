import java.io.*;

public class BOJ_11586 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());
        String[] input = new String[N];
        for (int i = 0; i < N; i++) input[i] = br.readLine();

        int K = Integer.parseInt(br.readLine());
        br.close();

        StringBuilder sb = new StringBuilder();

        if (K == 1) {
            for (int i = 0; i < N; i++) sb.append(input[i]).append("\n");
        } else if (K == 2) {
            int length = input[0].length();
            for (int i = 0; i < N; i++) {
                for (int j = length - 1; j >= 0; j--) sb.append(input[i].charAt(j));
                sb.append("\n");
            }
        } else {
            int length = input[0].length();
            for (int i = N-1; i >=0; i--) {
                sb.append(input[i]).append("\n");
            }
        }

        System.out.print(sb);
    }
}
