import java.io.*;

public class BOJ_1100 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;
        for (int i = 0; i < 8; i++) {
            String input = br.readLine();
            for (int j = 0; j < 4; j++) {
                int nextCol = (i % 2) + (j * 2);
                if (input.charAt(nextCol) == 'F') result++;
            }
        }
        System.out.println(result);
        br.close();
    }
}
