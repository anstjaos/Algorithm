import java.io.*;

public class BOJ_4458 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            int length = input.length();
            if ('a' <= input.charAt(0) && input.charAt(0) <= 'z') sb.append((char) (input.charAt(0) - 'a' + 'A'));
            else sb.append(input.charAt(0));
            for (int j = 1; j < length; j++) sb.append(input.charAt(j));

            sb.append("\n");
        }
        br.close();
        System.out.print(sb);
    }
}
