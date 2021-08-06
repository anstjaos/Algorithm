import java.io.*;

public class BOJ_4470 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            String input = br.readLine();
            sb.append(i + ". ").append(input).append("\n");
        }
        br.close();

        System.out.print(sb);
    }
}
