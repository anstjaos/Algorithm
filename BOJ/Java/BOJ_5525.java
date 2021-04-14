import java.io.*;

public class BOJ_5525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String input = br.readLine();

        int count = 0, result = 0;
        for (int i = 1; i < M - 1; i++) {
            if (input.charAt(i - 1) == 'I' && input.charAt(i) == 'O' && input.charAt(i + 1) == 'I') {
                count++;
                if (count == N) {
                    result++;
                    count--;
                }
                i++;
            } else count = 0;
        }
        System.out.println(result);
        br.close();
    }
}
