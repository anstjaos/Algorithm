import java.io.*;

public class BOJ_17389 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();
        br.close();

        int result = 0, bonus = 0;

        for (int i = 0; i < N; i++) {
            char cur = input.charAt(i);

            if (cur == 'O') {
                result += i + 1 + bonus;
                bonus++;
            } else {
                bonus = 0;
            }
        }

        System.out.println(result);
    }
}
