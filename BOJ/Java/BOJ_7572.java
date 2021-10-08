import java.io.*;

public class BOJ_7572 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());
        br.close();

        System.out.println((char) ((N + 8) % 12 + 'A') + "" + ((N + 6) % 10));
    }
}
