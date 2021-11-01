import java.io.*;

public class BOJ_5522 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int result = 0;

        for (int i = 0; i < 5; i++) {
            result += Integer.parseInt(br.readLine());
        }
        br.close();

        System.out.println(result);
    }
}
